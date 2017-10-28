package com.infoshareacademy.java.web.beans;

import com.infoshareacademy.java.web.entities.User;
import com.infoshareacademy.java.web.entities.UsersLogins;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;

@Stateless
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
