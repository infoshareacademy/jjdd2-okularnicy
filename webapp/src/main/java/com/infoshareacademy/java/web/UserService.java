package com.infoshareacademy.java.web;

import com.infoshareacademy.java.web.beans.UsersLoginsDAOBeanLocal;
import com.infoshareacademy.java.web.entities.User;
import com.infoshareacademy.java.web.entities.UsersLogins;

import javax.inject.Inject;
import java.time.LocalDate;

public class UserService {

    @Inject
    UserFactory userFactory;

    @Inject
    UsersLoginsDAOBeanLocal usersLoginsDAOBean;

    public boolean initUserSession (String accessToken) {
        String userId = userFactory.getUserId(accessToken);
        User user = userFactory.createUser(userId, accessToken);
        UsersLogins userlogin = new UsersLogins(user, LocalDate.now());
        usersLoginsDAOBean.addUserLogin(userlogin);
        boolean isAdmin = user.isAdmin();
        return isAdmin;
    }
}
