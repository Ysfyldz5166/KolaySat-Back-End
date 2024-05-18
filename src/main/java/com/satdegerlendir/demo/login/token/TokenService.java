package com.satdegerlendir.demo.login.token;

import com.satdegerlendir.demo.login.dto.Credentials;

import com.satdegerlendir.demo.user.user;

public interface TokenService {

    public Token createToken(user user, Credentials creds);

    public user verifyUser(String LoginHeader);
    
}
