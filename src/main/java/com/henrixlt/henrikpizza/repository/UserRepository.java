package com.henrixlt.henrikpizza.repository;

import com.henrixlt.henrikpizza.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
