package com.example.cmseventosapi.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cmseventosapi.Model.User;


/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    Optional<User> findByLogin(String login);
}