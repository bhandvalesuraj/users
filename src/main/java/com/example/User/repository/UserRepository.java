package com.example.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.User.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
