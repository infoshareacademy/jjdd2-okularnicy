package com.infoshareacademy.java.web.beans;

import com.infoshareacademy.java.web.entities.User;
import com.infoshareacademy.java.web.entities.UsersLogins;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UsersLoginsDAOBean implements UsersLoginsDAOBeanLocal {

    @PersistenceContext(name = "financeunit")
    EntityManager em;

    @Override
    public void addUserLogin(UsersLogins usersLogins) {
        em.persist(usersLogins);
    }

    @Override
    public List<User> findAllUsersLogins() {
        Query q = em.createNamedQuery("com.infoshareacademy.java.web.entities.UsersLogins.findAllLogins");
        return q.getResultList();
    }
}
