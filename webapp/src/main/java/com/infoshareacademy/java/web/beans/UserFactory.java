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
import java.util.Optional;

@Stateless
public class UserFactory {

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    @Inject
    UserDAOBeanLocal userDAOBean;

    public User createUser(String userId, String accessToken) {

        Optional<User> user = userDAOBean.findUserById(userId);
        if (user.isPresent()) {
            return user.get();
        }
        User newUser = new User(userId, false);
        userDAOBean.addUser(newUser);
        return newUser;
    }

    public String getUserId(String accessToken) {

        String url = "https://jjdd2okularnicy.eu.auth0.com/userinfo";
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(url);
        AuthClient authClient = target.proxy(AuthClient.class);
        String userIdJSON = authClient.getUserInfo("Bearer " + accessToken);
        String userId = userIdJSON.replaceAll("[{}]", " ");
        logger.info(userId);
        return userId;
    }
}
