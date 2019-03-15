package com.edulinks.vmeeting.repository;

import org.springframework.data.repository.CrudRepository;

import com.edulinks.vmeeting.bean.Meeting;;

public interface MeetingRepository extends CrudRepository<Meeting, Integer> {
    
}