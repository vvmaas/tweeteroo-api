package com.tweeteroo.tweeteroo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TweetDTO(

    @NotBlank
    @NotNull
    String username,

    @NotBlank
    @NotNull
    String avatar,

    @NotBlank
    @NotNull
    String text
) {
    
}
