package com.Kevin.BloggingPlatformAPI.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post,Long> {
    Page<Post> findById(Long id, Pageable paginacion);

    @Query("SELECT p FROM Post p WHERE p.category ILIKE %:term% OR p.title ILIKE %:term% OR p.category ILIKE %:term% ")
    Page<Post> findposts(String term,Pageable paginacion);
}

