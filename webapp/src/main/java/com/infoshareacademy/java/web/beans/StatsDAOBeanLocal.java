package com.infoshareacademy.java.web.beans;

import com.infoshareacademy.java.web.entities.Stats;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

@Local
public interface StatsDAOBeanLocal {
    void addStats(Stats stats);

    void updateStats(Stats stats);

    void deleteStats(Integer id);

    Stats findStatsById(Integer id);

    List<Stats> findAllStats();

    List<Stats> findAllStatsAfterDate(Date date);
}
