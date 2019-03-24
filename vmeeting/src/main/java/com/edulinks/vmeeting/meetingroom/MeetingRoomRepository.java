package com.edulinks.vmeeting.meetingroom;

import org.springframework.data.repository.CrudRepository;

import com.edulinks.vmeeting.meetingroom.MeetingRoom;

public interface MeetingRoomRepository extends CrudRepository<MeetingRoom, Integer> {
    
}