package com.tweeteroo.tweeteroo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweeteroo.tweeteroo.models.Tweet;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    
    List<Tweet> findByUsername(String username);
    
}
