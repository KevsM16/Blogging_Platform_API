package com.Kevin.BloggingPlatformAPI.Post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RegisteryPost(
        @NotBlank
        String title,
        @NotBlank
        String content,
        @NotBlank
        String category,
        @NotNull
        List<String> tags) {
}
