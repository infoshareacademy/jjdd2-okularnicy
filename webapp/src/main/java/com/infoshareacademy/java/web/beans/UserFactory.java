package com.infoshareacademy.java.web.beans;

import com.infoshareacademy.java.web.beans.UserDAOBeanLocal;
import com.infoshareacademy.java.web.entities.User;
import com.infoshareacademy.java.web.login.AuthClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserFactory {

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    @Inject
    UserDAOBeanLocal userDAOBean;

    public User createUser(String userId, String accessToken) {

        User user = userDAOBean.findUserById(userId);
        if (user == null) {
            user = new User(userId, false, getUserEmail(userId, accessToken));
            userDAOBean.addUser(user);
        }
        return user;
    }

    public String getUserId(String accessToken) {

        String url = "jjdd2okularnicy.eu.auth0.com/userinfo";
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(url);
        AuthClient authClient = target.proxy(AuthClient.class);
        String userId = authClient.getUserInfo("Bearer " + accessToken);
        logger.info(userId);
        return userId;
    }

    public String getUserEmail(String userId, String accessToken){
        String url = "https://okularnicy.eu.auth0.com/api/v2/users/" + userId;
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(url);
        AuthClient authClient = target.proxy(AuthClient.class);
        String userEmail = authClient.getUserEmail("Bearer " + accessToken);
        logger.info(userEmail);
        return userEmail;
    }

}
