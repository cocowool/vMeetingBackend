package com.edulinks.vmeeting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HomeController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String Index() {
        return "Welcome to vMeeting";
    }
    
}