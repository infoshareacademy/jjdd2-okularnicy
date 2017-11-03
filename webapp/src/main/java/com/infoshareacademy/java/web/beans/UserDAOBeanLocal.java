package com.infoshareacademy.java.web.beans;

import com.infoshareacademy.java.web.entities.User;

import javax.ejb.Local;
import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Local
public interface UserDAOBeanLocal {

    void addUser(User user);

    void updateUser(User user);

    Optional<User> findUserById (String userId);

    List<User> findAllUsers();



}