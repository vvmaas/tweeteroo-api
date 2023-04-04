package com.tweeteroo.tweeteroo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.tweeteroo.tweeteroo.dto.TweetDTO;
import com.tweeteroo.tweeteroo.dto.TweetPostDTO;
import com.tweeteroo.tweeteroo.models.Tweet;
import com.tweeteroo.tweeteroo.service.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetService service;

    @PostMapping
    public String create(@RequestBody @Valid TweetPostDTO body) {
        service.create(body);
        return "OK";
    }

    @GetMapping
    public List<Tweet> findAll(@RequestParam(defaultValue = "0") int page) {
        return service.findAll(page);
    }

    @GetMapping("/{username}")
    public List<Tweet> find(@PathVariable String username) {
        return service.findByUser(username);
    }
}

