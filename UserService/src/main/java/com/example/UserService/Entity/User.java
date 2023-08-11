package com.example.UserService.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "userinfo")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private String username;
    @Column
    private String  password;
    public User(String username,String password){
        this.username = username;
        this.password = password;
    }
    public User(){

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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
