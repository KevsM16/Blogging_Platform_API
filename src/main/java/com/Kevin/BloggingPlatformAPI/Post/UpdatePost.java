package com.Kevin.BloggingPlatformAPI.Post;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UpdatePost( String title, String content, String category, List<String>tags) {
}
