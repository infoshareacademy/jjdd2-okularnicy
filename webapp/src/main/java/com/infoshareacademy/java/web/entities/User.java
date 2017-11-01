package com.infoshareacademy.java.web.entities;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(query = "SELECT u FROM User u", name = "com.infoshareacademy.java.web.entities.User.findAllUsers"),
        @NamedQuery(query = "SELECT u FROM User u WHERE u.userId=:userId", name = "com.infoshareacademy.java.web.entities.User.findByUserId"),
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

    @OneToMany(mappedBy = "user")
    private List<UsersLogins> logins;

    public User() {
    }

    public User(String userId, boolean isAdmin) {
        this.userId = userId;
        this.isAdmin = isAdmin;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UsersLogins> getLogins() {
        return logins;
    }

    public void setLogins(List<UsersLogins> logins) {
        this.logins = logins;
    }
}