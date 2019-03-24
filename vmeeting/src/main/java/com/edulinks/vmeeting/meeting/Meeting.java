package com.edulinks.vmeeting.meeting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Meeting{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String name;
    private Integer attendance;
    private Date meetingtime;
    private Integer booker;
    private Date starttime;
    private Date endtime;

    // public Meeting(long id, String name){
    // this.id = id;
    // this.name = name;
    // }

    public Integer getId() {
        return id;
    }

    /**
     * @return the endtime
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * @param endtime the endtime to set
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * @return the starttime
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * @param starttime the starttime to set
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * @return the booker
     */
    public Integer getBooker() {
        return booker;
    }

    /**
     * @param booker the booker to set
     */
    public void setBooker(Integer booker) {
        this.booker = booker;
    }

    /**
     * @return the meetingtime
     */
    public Date getMeetingtime() {
        return meetingtime;
    }

    /**
     * @param meetingtime the meetingtime to set
     */
    public void setMeetingtime(Date meetingtime) {
        this.meetingtime = meetingtime;
    }

    public String getName() {
        return name;
    }

    public Integer getAttendance(){
        return attendance;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAttendance(Integer attendance){
        this.attendance = attendance;
    }
}