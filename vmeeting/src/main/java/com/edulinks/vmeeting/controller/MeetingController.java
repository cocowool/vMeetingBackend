package com.edulinks.vmeeting.controller;

import com.edulinks.vmeeting.bean.Meeting;
import com.edulinks.vmeeting.bean.User;
import com.edulinks.vmeeting.controller.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeetingController {
    @Autowired

    private static final String template = "Hello, %d!";
    private final AtomicLong counter = new AtomicLong();

    private UserRepository userRepository;

    @RequestMapping("/meeting")
    public Meeting meeting(@RequestParam(value="id", defaultValue="0", required=true) long id) {
        User n = new User();
        n.setName("Wang");
        userRepository.save(n);

        return new Meeting(counter.incrementAndGet(),
                            String.format(template, id));
    }
}