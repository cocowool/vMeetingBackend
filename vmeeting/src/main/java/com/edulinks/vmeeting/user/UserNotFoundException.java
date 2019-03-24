package com.edulinks.vmeeting.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public UserNotFoundException(String string) {
        super(String.format("%s not foud" , string));
    }

	// public String __Construct(String str){
    //     return str;
    // }
}