package com.satdegerlendir.demo.user;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void save(user user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setActivationToken(UUID.randomUUID().toString());
            userRepository.save(user);

            sendActivationEmail(user);
        } catch (DataIntegrityViolationException e) {
            throw new NotUniqueEmailException();
        }
    }

    public user findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private void sendActivationEmail(user user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("info@yusufkolaysat.com.tr");
        message.setTo(user.getEmail());
        message.setSubject("Account Activation");
        message.setText("http://localhost:5173/activation/" + user.getActivationToken());
        getJavaMailSender().send(message);
    }

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.ethereal.email");
        mailSender.setPort(587);
        mailSender.setUsername("teresa36@ethereal.email");
        mailSender.setPassword("hT3g6zT9Qxdkdm7ahb");

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        return mailSender;
    }

    public List<user> GetAllUsers() {
        return userRepository.findAll();
    }

    public user updateUser(Long userId, user newUser) {
        Optional<user> user = userRepository.findById(userId);
        if (user.isPresent()) {
            user foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setEmail(newUser.getEmail());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else {
            return null;
        }
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public user GetByIdUsers(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

}

/*
 * 
 * 
 * Name Teresa Welch
 * Username teresa36@ethereal.email
 * Password hT3g6zT9Qxdkdm7ahb
 */