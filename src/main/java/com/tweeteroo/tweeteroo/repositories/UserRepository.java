package com.tweeteroo.tweeteroo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweeteroo.tweeteroo.models.UserT;

import java.util.List;

public interface UserRepository extends JpaRepository<UserT, Long> {
    
    List<UserT> findByUsername(String username);
}
