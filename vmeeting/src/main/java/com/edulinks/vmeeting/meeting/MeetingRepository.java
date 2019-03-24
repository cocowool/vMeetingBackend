package com.edulinks.vmeeting.meeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import org.springframework.data.repository.CrudRepository;

import com.edulinks.vmeeting.meeting.Meeting;;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
    
}