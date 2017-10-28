package com.infoshareacademy.java.web.entities;

import javax.persistence.*;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(query = "SELECT l FROM UsersLogins l", name = "com.infoshareacademy.java.web.entities.UsersLogins.findAllLogins"),
})

@Entity
@Table(name = "USERS_LOGINS")
public class UsersLogins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "login_time")
    private LocalDate loginTime;

    public UsersLogins() {
    }

    public UsersLogins(User user, LocalDate loginTime) {
        this.user = user;
        this.loginTime = loginTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDate loginTime) {
        this.loginTime = loginTime;
    }
}
