package com.edulinks.vmeeting.repository;

import org.springframework.data.repository.CrudRepository;

import com.edulinks.vmeeting.bean.MeetingRoom;

public interface MeetingRoomRepository extends CrudRepository<MeetingRoom, Integer> {
    
}