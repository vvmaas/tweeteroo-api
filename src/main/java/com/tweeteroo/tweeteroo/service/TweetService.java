package com.tweeteroo.tweeteroo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweeteroo.tweeteroo.dto.TweetDTO;
import com.tweeteroo.tweeteroo.dto.TweetPostDTO;
import com.tweeteroo.tweeteroo.models.Tweet;
import com.tweeteroo.tweeteroo.repositories.TweetRepository;
import com.tweeteroo.tweeteroo.repositories.UserRepository;
import com.tweeteroo.tweeteroo.models.UserT;

import java.util.*;

@Service
public class TweetService {
    
    @Autowired
    private TweetRepository repository;

    @Autowired
    private UserRepository userRepository;

    public Tweet create(TweetPostDTO body) {
        System.out.println(body.username());
        List<UserT> users = userRepository.findByUsername(body.username());
        UserT user = users.get(0);

        return repository.save(new Tweet(body, user.getAvatar()));
    }

    public List<Tweet> findAll(int page) {

        Pageable paging = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
        Page<Tweet> tweets = repository.findAll(paging);
        
        return tweets.getContent();
    }

    public List<Tweet> findByUser(String username) {
        return repository.findByUsername(username);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, TweetDTO body) {
        repository.findById(id).map(user -> {
            user.setUsername(body.username());
            user.setAvatar(body.avatar());
            user.setText(body.text());
            return repository.save(user);
        });
    }
}