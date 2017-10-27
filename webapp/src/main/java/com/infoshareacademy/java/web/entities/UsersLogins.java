package com.infoshareacademy.java.web.entities;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(query = "SELECT l FROM UsersLogins l", name = "com.infoshareacademy.java.web.entities.UsersLogins.findAll"),
})

@Entity
@Table(name = "USERS_LOGINS")
public class UsersLogins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String UserId;

    @Column(name = "login_time")
    private LocalDate loginTime;

    public UsersLogins(String userId, LocalDate loginTime) {
        UserId = userId;
        this.loginTime = loginTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public LocalDate getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDate loginTime) {
        this.loginTime = loginTime;
    }
}
