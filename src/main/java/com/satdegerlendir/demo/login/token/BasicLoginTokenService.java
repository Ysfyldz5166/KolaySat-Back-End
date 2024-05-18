package com.satdegerlendir.demo.login.token;

import java.util.Base64;

import org.springframework.stereotype.Service;

import com.satdegerlendir.demo.login.dto.Credentials;
import com.satdegerlendir.demo.user.user;

@Service
public class BasicLoginTokenService implements TokenService {

    @Override
    public Token createToken(user user, Credentials creds) {
        String emailColonPasword = creds.email()+":"+creds.password();
        String token= Base64.getEncoder().encodeToString(emailColonPasword.getBytes());
        return new Token("Basic",token);
    }
    public user verifyUser(String LoginHeader) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyUser'");
    }
    
}
