package com.Kevin.BloggingPlatformAPI.Post;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name="Post")
@Table(name="posts")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Post {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String title;
 private String content;
 private String category;
private LocalDateTime createdAt;
private LocalDateTime updatedAt;

 @ElementCollection
 @CollectionTable(name = "posts_tags", joinColumns = @JoinColumn(name = "post_id"))
 @Column(name = "tag")
 private List<String>tags;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getTags() {
        return tags;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public  Post(){}
    public Post(RegisteryPost registeryPost) {
        this.title=registeryPost.title();
        this.content=registeryPost.content();
        this.category=registeryPost.category();
        this.tags=registeryPost.tags();
        this.updatedAt=LocalDateTime.now();
        this.createdAt=LocalDateTime.now();
    }

    public void updatePosts(@Valid UpdatePost updatePost) {
        if(updatePost.content()!=null){
            this.content= updatePost.content();
        }
        if(updatePost.title()!=null){
            this.title= updatePost.title();
        }
        if(updatePost.category()!=null){
            this.category= updatePost.category();
        }

        if(updatePost.tags()!=null){
            this.tags=updatePost.tags();
        }
        this.updatedAt=LocalDateTime.now();
    }


}
