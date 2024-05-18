package com.satdegerlendir.demo.login;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satdegerlendir.demo.error.ApiError;
import com.satdegerlendir.demo.login.dto.Credentials;
import com.satdegerlendir.demo.login.dto.LoginResponse;
import com.satdegerlendir.demo.login.exception.loginException;

import jakarta.validation.Valid;


@RestController
public class LoginController {


    @Autowired
    LoginService loginService;

    @PostMapping("/api/v1/login")
    LoginResponse handleLogin(@Valid @RequestBody Credentials creds) {
        return loginService.login(creds);
    }

    @ExceptionHandler(LoginException.class)
    ResponseEntity<?> handleLoginException(loginException exception){
        ApiError error = new ApiError();
        error.setPath("/api/v1/login");
        error.setStatus(401);
        error.setMessage(exception.getMessage());
        return ResponseEntity.status(400).body(error);
    }

}
