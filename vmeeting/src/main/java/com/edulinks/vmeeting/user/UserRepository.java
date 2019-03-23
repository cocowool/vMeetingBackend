package com.edulinks.vmeeting.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import org.springframework.data.repository.CrudRepository;

import com.edulinks.vmeeting.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}