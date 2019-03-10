package com.edulinks.vmeeting.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value="/api/user")
@EnableAutoConfiguration
public class UserController {

    @RequestMapping(value="/api/user", method=RequestMethod.GET)
    public String Index(@RequestParam(value = "userId", required = true) int userId) {
        return "Welcome to vMeeting User Controller";
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public boolean addUser() {
        return true;
    }
    
}