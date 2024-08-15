package com.jbs.javabookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jbs.javabookstore.model.User;
import com.jbs.javabookstore.model.UserLogin;
import com.jbs.javabookstore.repository.UserRepository;
import com.jbs.javabookstore.security.JwtService;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Optional<User> registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            return Optional.empty();
        user.setPassword(encryptPassword(user.getPassword()));
        return Optional.of(userRepository.save(user));
    }

    public Optional<User> updateUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {

            Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

            if (existingUser.isPresent() && !existingUser.get().getId().equals(user.getId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
            }

            user.setPassword(encryptPassword(user.getPassword()));
            return Optional.ofNullable(userRepository.save(user));
        }

        return Optional.empty();
    }

    public Optional<UserLogin> authenticateUser(Optional<UserLogin> userLogin) {

        var credentials = new UsernamePasswordAuthenticationToken(userLogin.get().getEmail(),
                userLogin.get().getPassword());

        Authentication authentication = authenticationManager.authenticate(credentials);

        if (authentication.isAuthenticated()) {

            Optional<User> user = userRepository.findByEmail(userLogin.get().getEmail());

            if (user.isPresent()) {

                userLogin.get().setId(user.get().getId());
                userLogin.get().setName(user.get().getName());
                userLogin.get().setToken(generateToken(userLogin.get().getEmail()));
                userLogin.get().setPassword("");

                return userLogin;
            }
        }

        return Optional.empty();
    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    private String generateToken(String email) {
        return "Bearer " + jwtService.generateToken(email);
    }
}
