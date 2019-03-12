package com.edulinks.vmeeting.controller;

import org.springframework.data.repository.CrudRepository;

import com.edulinks.vmeeting.bean.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}