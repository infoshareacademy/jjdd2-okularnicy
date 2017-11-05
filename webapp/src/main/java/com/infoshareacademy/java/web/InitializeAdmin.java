package com.infoshareacademy.java.web;

import com.infoshareacademy.java.web.beans.UserFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class InitializeAdmin {

    @Inject
    UserFactory userFactory;

    @PostConstruct
    void initializeAdmin () {
        userFactory.addAdmin("{\"sub\":\"google-oauth2|100373025389913950642\"}");
        userFactory.addAdmin("{\"sub\":\"google-oauth2|101939476130838913705\"}");
    }

}

