package com.satdegerlendir.demo.user.dto;

import com.satdegerlendir.demo.user.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record userCreate(
        @NotBlank(message = "{kolaysat.constraint.username.notblank}") @Size(min = 2, max = 150) String userName,

        @NotBlank @Email String email,

        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{kolaysat.constraint.password.pattern}") String password) {

    public user toUser() {
        user user = new user();

        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }

}
