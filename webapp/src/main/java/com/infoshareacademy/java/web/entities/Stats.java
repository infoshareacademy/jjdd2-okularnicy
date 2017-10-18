package com.infoshareacademy.java.web.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(query = "SELECT s FROM Stats s", name = "com.infoshareacademy.java.web.entities.Stats.findAll"),
        @NamedQuery(query = "SELECT s FROM Stats s WHERE s.meetingTime >= :afterDate", name = "com.infoshareacademy.java.web.entities.Stats.findAllAfterDate")
})
@Entity
@Table(name = "T_STATS")
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "stats_name")
    private String statsName;

    @Column(name = "stats_datetime")
    private Date meetingTime;

    @OneToMany(mappedBy = "stats")
    private List<Stats> attendees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatsNameName() {
        return statsName;
    }

    public void setStatsNameName(String meetingName) {
        this.statsName = meetingName;
    }

    public Date getStatsTime() {
        return meetingTime;
    }

    public void setMeetingTime(Date meetingTime) {
        this.meetingTime = meetingTime;
    }

}

