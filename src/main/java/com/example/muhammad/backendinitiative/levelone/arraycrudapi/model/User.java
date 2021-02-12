package com.example.muhammad.backendinitiative.levelone.arraycrudapi.model;

import com.example.muhammad.backendinitiative.levelone.arraycrudapi.security.ValidPassword;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class User {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Date dob;
    private String email;
    private String username;
    @ValidPassword
    private String password;

    protected User() {
    }

    public User(String name, Date dob, String email, String username, String password) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
