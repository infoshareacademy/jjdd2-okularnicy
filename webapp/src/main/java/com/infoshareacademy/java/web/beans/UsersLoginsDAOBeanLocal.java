package com.infoshareacademy.java.web.beans;

import com.infoshareacademy.java.web.entities.User;
import com.infoshareacademy.java.web.entities.UsersLogins;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

@Local
public interface UsersLoginsDAOBeanLocal {

    void addUserLogin(UsersLogins usersLogins);

    List<User> findAllUsersLogins();
}

