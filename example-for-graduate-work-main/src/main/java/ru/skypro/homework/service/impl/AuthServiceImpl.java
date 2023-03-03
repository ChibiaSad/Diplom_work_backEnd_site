package ru.skypro.homework.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.RegisterReq;
import ru.skypro.homework.dto.Role;
import ru.skypro.homework.service.AuthService;


@Service
public class AuthServiceImpl implements AuthService {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder encoder;
    private final UserServiceImpl userService;

    public AuthServiceImpl(UserDetailsService userDetailsService, PasswordEncoder encoder, UserServiceImpl userService) {
        this.userDetailsService = userDetailsService;
        this.encoder = encoder;
        this.userService = userService;

    }

    @Override
    public boolean login(String userName, String password) {
        if (userService.userExists(userName).isEmpty()) {
            return false;
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        String encryptedPassword = userDetails.getPassword();
        return encoder.matches(password, encryptedPassword);
    }

    @Override
    public boolean register(RegisterReq registerReq, Role role) {
        if (userService.userExists(registerReq.getUsername()).isPresent()) {
            return false;
        }

        String encodedPassword = encoder.encode(registerReq.getPassword());
        registerReq.setPassword(encodedPassword);
        registerReq.setRole(role);
        userService.createUser(registerReq);
        return true;
    }
}
