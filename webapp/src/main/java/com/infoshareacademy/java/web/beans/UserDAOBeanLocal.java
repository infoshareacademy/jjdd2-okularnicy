package com.infoshareacademy.java.web.beans;

import com.infoshareacademy.java.web.entities.User;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

@Local
public interface UserDAOBeanLocal {

    void addUser(User user);

    void updateUser(User user);

    User findUserById (String userId);

    List<User> findAllUsers();



}