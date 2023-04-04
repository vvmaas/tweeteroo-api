package com.tweeteroo.tweeteroo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweeteroo.tweeteroo.dto.UserDTO;
import com.tweeteroo.tweeteroo.models.UserT;
import com.tweeteroo.tweeteroo.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public void create(UserDTO body) {
        repository.save(new UserT(body));
    }

    public List<UserT> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, UserDTO body) {
        repository.findById(id).map(user -> {
            user.setUsername(body.username());
            user.setAvatar(body.avatar());
            return repository.save(user);
        });
    }
}
