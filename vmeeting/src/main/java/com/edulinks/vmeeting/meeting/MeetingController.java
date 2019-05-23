package com.edulinks.vmeeting.meeting;

import com.edulinks.vmeeting.meeting.*;
import com.edulinks.vmeeting.user.User;
import com.edulinks.vmeeting.user.UserRepository;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

@RestController
public class MeetingController implements Watcher {
    private static final int SESSION_TIMEOUT = 1000; // 回话超时时间
    private static CountDownLatch latch = new CountDownLatch(1);
    private ZooKeeper zk;
    private static final String REGISTRY_PATH = "/registry";

    @Autowired
    private MeetingRepository meetingRepository;

    Watcher wh = new Watcher(){
        public void process(org.apache.zookeeper.WatchedEvent event){
            System.out.println(event.toString());
        }
    };

    // ZK测试
    @RequestMapping("/zk")
    public String testZk() throws InterruptedException, KeeperException {

        try {
            zk = new ZooKeeper("localhost:2181", SESSION_TIMEOUT, this.wh);
            // latch.await();

            if(zk.exists(REGISTRY_PATH, false) == null){
                zk.create(REGISTRY_PATH, "hello registry".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

                System.out.println(new String(zk.getData(REGISTRY_PATH, false, null)));
            }else{
                zk.setData(REGISTRY_PATH, "hello zk".getBytes(), 0);
                zk.close();

                System.out.println(new String(zk.getData(REGISTRY_PATH, false, null)));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // ZooKeeper zk = null;

        return "zk test";
    }

    // Post请求，新增会议
    @PostMapping("/meeting/add")
    public @ResponseBody Meeting addNewMeeting(@RequestBody Meeting meeting) {
        meetingRepository.save(meeting);


        return meeting;
    }

    @RequestMapping("/meeting")
    public @ResponseBody Iterable<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    @GetMapping("/meeting/{id}")
    public Meeting getSingleMeeting(@PathVariable("id") Integer id) {
        // return userRepository.findById(id);
        Optional<Meeting> meeting = meetingRepository.findById(id);
        if (!meeting.isPresent()) {
            throw new MeetingNotFoundException("id-" + id);
        }

        return meeting.get();
    }

    @PutMapping("/meeting/{id}")
    public ResponseEntity<Object> updateMeeting(@RequestBody Meeting meeting, @PathVariable Integer id) {
        Optional<Meeting> meetingOptional = meetingRepository.findById(id);

        if (!meetingOptional.isPresent()) {
            throw new MeetingNotFoundException("id-" + id);
            // return ResponseEntity.notFound().build();
        }

        meeting.setId(id);
        // @TODO 判断上送了哪些字段并进行更新
        meetingRepository.save(meeting);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/meeting/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String id) {
        // 如果不判断，会发生 org.springframework.dao.EmptyResultDataAccessException 异常
        if (meetingRepository.existsById(Integer.parseInt(id))) {
            meetingRepository.deleteById(Integer.parseInt(id));
            return "deleted";
        } else {
            throw new MeetingNotFoundException("id-" + id);
            // return "error";
        }
    }

    @Override
    public void process(WatchedEvent event) {

    }
    
}