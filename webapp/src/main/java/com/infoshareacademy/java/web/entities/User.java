package com.infoshareacademy.java.web.entities;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(query = "SELECT u FROM User u", name = "com.infoshareacademy.java.web.entities.User.findAllUsers"),
})

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @Column(name = "isAdmin")
    private boolean isAdmin;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToMany(mappedBy = "user")
    private List<UsersLogins> logins;

    public User() {
    }

    public User(String userId, boolean isAdmin, String emailAddress) {
        this.userId = userId;
        this.isAdmin = isAdmin;
        this.emailAddress = emailAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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