package com.tweeteroo.tweeteroo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TweetPostDTO(

    @NotNull
    @NotBlank
    String username,

    @NotNull
    @NotBlank
    String tweet
) {
    
}
