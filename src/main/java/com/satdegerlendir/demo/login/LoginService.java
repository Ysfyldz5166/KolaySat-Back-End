package com.satdegerlendir.demo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.satdegerlendir.demo.login.dto.Credentials;
import com.satdegerlendir.demo.login.dto.LoginResponse;
import com.satdegerlendir.demo.login.exception.loginException;
import com.satdegerlendir.demo.login.token.Token;
import com.satdegerlendir.demo.login.token.TokenService;
import com.satdegerlendir.demo.user.UserService;
import com.satdegerlendir.demo.user.user;
import com.satdegerlendir.demo.user.dto.UserDto;

@Service
public class LoginService {

    @Autowired
    UserService userService;

    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Autowired
    TokenService tokenService;


    public LoginResponse login(Credentials creds) {
        user inDb = userService.findByEmail((creds.email()));
        if(inDb==null) throw new loginException("Kullanıcı bulunamadı");
        if(!passwordEncoder.matches(creds.password(), inDb.getPassword()))throw new loginException("Şifre Bilgisi Hatalı");
    
        Token token = tokenService.createToken(inDb, creds);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        loginResponse.setUser(new UserDto(inDb));
        return loginResponse;
    
    }

}
