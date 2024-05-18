package com.satdegerlendir.demo.user.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.satdegerlendir.demo.user.UserRepository;
import com.satdegerlendir.demo.user.user;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String>{

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        user inDb= userRepository.findByEmail(value);
        return inDb == null;
    
    }
    
}
