package com.applyflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applyflow.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}