package com.satdegerlendir.demo.login.dto;

import com.satdegerlendir.demo.login.token.Token;
import com.satdegerlendir.demo.user.dto.UserDto;

public class LoginResponse {

    UserDto user;

    Token token;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
    
}

