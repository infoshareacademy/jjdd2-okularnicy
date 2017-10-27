package com.infoshareacademy.java.web.beans;

import com.infoshareacademy.java.web.entities.User;
import com.infoshareacademy.java.web.entities.UsersLogins;

import java.util.List;

public interface UsersLoginsDAOBeanLocal {

    void addUserLogin(UsersLogins usersLogins);

    void updateUserLogin(UsersLogins usersLogins);

    List<User> findAllUsersLogins();
}

