package com.edulinks.vmeeting.user;

import com.edulinks.vmeeting.user.User;
import com.edulinks.vmeeting.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user/add")
    public String addNewUser(@RequestParam String name ) {
        User n = new User();
        n.setName(name);
        userRepository.save(n);

        return "ok";
    }

    @RequestMapping("/user")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping("/user/update")
    public String updateUser(@RequestParam Integer id, @RequestParam String name){
        User n = new User();
        n.setId(id);
        n.setName(name);

        userRepository.save(n);

        return "updated";
    }

    @RequestMapping(value="/user/delete/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable("id") String id) {
        userRepository.deleteById(Integer.parseInt(id));

        return "deleted";
        // return new SomeData();
    }
    
}