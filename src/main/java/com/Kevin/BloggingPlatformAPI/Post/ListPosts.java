package com.Kevin.BloggingPlatformAPI.Post;

import java.time.LocalDateTime;
import java.util.List;

public record ListPosts(Long id, String title, String content, String category, List<String> tags, LocalDateTime createdAt, LocalDateTime updatedAt) {
 public  ListPosts(Post post){
      this(post.getId(), post.getTitle(), post.getContent(), post.getCategory(),post.getTags(),post.getCreatedAt(),post.getUpdatedAt());
  }
}
