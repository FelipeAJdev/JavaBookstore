package com.jbs.javabookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.jbs.javabookstore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // SELECT * FROM tb_users WHERE email = ?;
    public Optional<User> findByEmail(@Param("email") String email);
}
