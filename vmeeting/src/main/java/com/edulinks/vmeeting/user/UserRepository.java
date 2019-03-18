package com.edulinks.vmeeting.user;

import org.springframework.data.repository.CrudRepository;

import com.edulinks.vmeeting.user.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}