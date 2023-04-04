package com.tweeteroo.tweeteroo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.tweeteroo.tweeteroo.dto.UserDTO;

@Data
@Entity
@NoArgsConstructor
public class UserT {

    public UserT(UserDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String username;

    @Column(nullable=false)
    private String avatar;
}
