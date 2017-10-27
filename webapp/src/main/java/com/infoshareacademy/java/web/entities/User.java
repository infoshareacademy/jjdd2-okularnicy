package com.infoshareacademy.java.web.entities;

import javax.persistence.*;
import java.sql.Date;

@NamedQueries({
        @NamedQuery(query = "SELECT u FROM User u", name = "com.infoshareacademy.java.web.entities.Stats.findAll"),
})

@Entity
@Table(name = "USERS")
public class User {

    @Id
    private String UserId;

    @Column(name = "isAdmin")
    private boolean isAdmin;

    @Column(name = "email_address")
    private String emailAddress;

    public User(String userId, boolean isAdmin, String emailAddress) {
        UserId = userId;
        this.isAdmin = isAdmin;
        this.emailAddress = emailAddress;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}