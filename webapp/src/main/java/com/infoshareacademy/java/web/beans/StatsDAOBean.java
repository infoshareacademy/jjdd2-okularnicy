package com.infoshareacademy.java.web.beans;

import com.infoshareacademy.java.web.entities.Stats;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Stateless
public class StatsDAOBean implements StatsDAOBeanLocal {
    @PersistenceContext(name = "financeunit")
    EntityManager em;

    public void addStats(Stats stats) {
        em.persist(stats);
    }

    public void updateStats(Stats stats) {
        em.merge(stats);
    }

    public void deleteStats(Integer id) {
        Stats stats = em.find(Stats.class, id);
        if (stats != null) {
            em.remove(stats);
        }
    }

    @Override
    public Stats findStatsById(Integer id) {
        return em.find(Stats.class, id);
    }

    public List<Stats> findAllStats() {
        Query q = em.createNamedQuery("com.infoshareacademy.java.web.entities.Stats.findAll");
        return q.getResultList();

    }

    public List<Stats> findAllStatsAfterDate(Date date) {
        Query q = em.createNamedQuery("com.infoshareacademy.java.web.entities.Stats.findAllAfterDate");
        q.setParameter("afterDate", date);
        return q.getResultList();
    }
}
