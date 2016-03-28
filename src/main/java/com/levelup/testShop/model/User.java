package com.levelup.testShop.model;

import javax.persistence.*;

/**
 * Created by java on 21.03.2016.
 */
@Entity
@Table(name = "user_table")
public class User {
    private long id;
    private String email;
    private String pass;

    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    public long getId() {
        return id;
    }

    @Column(name = "user_email", nullable = false)
    public String getEmail() {
        return email;
    }

    @Column(name = "user_pass", nullable = false)
    public String getPass() {
        return pass;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
