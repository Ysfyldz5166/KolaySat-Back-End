package com.satdegerlendir.demo.user.dto;

import com.satdegerlendir.demo.user.user;

public class UserDto {
    long id;

    String username;

    String email;


    public UserDto(user user){
        setId(user.getId());
        setUsername(user.getUserName());
        setEmail(user.getEmail());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
