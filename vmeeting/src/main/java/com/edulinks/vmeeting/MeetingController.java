package com.edulinks.vmeeting;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeetingController {

    private static final String template = "Hello, %d!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/meeting")
    public Meeting meeting(@RequestParam(value="id", defaultValue="0", required=true) long id) {
        return new Meeting(counter.incrementAndGet(),
                            String.format(template, id));
    }
}