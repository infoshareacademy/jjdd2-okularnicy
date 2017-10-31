package com.infoshareacademy.java.web;

import com.infoshareacademy.java.web.beans.UserDAOBeanLocal;
import com.infoshareacademy.java.web.entities.User;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
public class initializeAdmin {

    @Inject
    UserDAOBeanLocal userDAOBean;

    @PostConstruct
    public void initialize() {
        User user = new User("{\"sub\":\"google-oauth2|100906147796526824516\"}", true);
        userDAOBean.addUser(user);
    }

}
