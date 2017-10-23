package com.infoshareacademy.java.web.entities;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;


@NamedQueries({
        @NamedQuery(query = "SELECT s FROM Stats s", name = "com.infoshareacademy.java.web.entities.Stats.findAll"),
        @NamedQuery(query = "SELECT s FROM Stats s WHERE s.statsTime >= :afterDate", name = "com.infoshareacademy.java.web.entities.Stats.findAllAfterDate")
})
@Entity
@Table(name = "STATS")
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "stats_name")
    private String statsName;

    @Column(name = "stats_datetime")
    private LocalDateTime statsTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatsName() {
        return statsName;
    }

    public void setStatsName(String meetingName) {
        this.statsName = meetingName;
    }

    public LocalDateTime getStatsTime() {
        return statsTime;
    }

    public void setStatsTime(LocalDateTime statsTime) {
        this.statsTime = statsTime;
    }

}

