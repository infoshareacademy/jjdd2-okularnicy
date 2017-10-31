package com.infoshareacademy.java.web.beans;

import com.infoshareacademy.java.web.entities.Stats;
import com.infoshareacademy.java.web.entities.User;

import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserDAOBean implements UserDAOBeanLocal {

    @PersistenceContext(name = "financeunit")
    EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public Optional<User> findUserById(String userId) {
        Query q = em.createNamedQuery("com.infoshareacademy.java.web.entities.User.findByUserId", User.class);
        q.setParameter("userId", userId);
        try {
            User foundUser = (User) q.getSingleResult();
            return Optional.of(foundUser);
        } catch (NoResultException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAllUsers() {
        Query q = em.createNamedQuery("com.infoshareacademy.java.web.entities.User.findAllUsers");
        return q.getResultList();
    }

}
