package com.Kevin.BloggingPlatformAPI.controller;

import com.Kevin.BloggingPlatformAPI.Post.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
@RequestMapping("/posts")
public class BlogController {

 @Autowired
 PostRepository postRepository;

 @PostMapping
  public void sendDatesPost( @RequestBody @Valid RegisteryPost registeryPost){
    postRepository.save(new Post(registeryPost));
}

@GetMapping
    public Page<ListPosts> getPosts( Pageable paginacion){
     return postRepository.findAll(paginacion).map(ListPosts::new);
}

    @GetMapping("/{id}")
    public Page<ListPosts> getPostsByid(Pageable paginacion,@PathVariable Long id) {
      return postRepository.findById(id,paginacion).map(ListPosts::new);
    }

@GetMapping(params="term")
public Page<ListPosts> getPostsByTitle( Pageable paginacion,@RequestParam(name="term",required = false) String term) {
return postRepository.findposts(term,paginacion).map(ListPosts::new);
}


@PutMapping("/{id}")
@Transactional
    public void updateBlog(@RequestBody @Valid UpdatePost updatePost,@PathVariable Long id){
      Post post = postRepository.getReferenceById(id);
       post.updatePosts(updatePost);
}

@DeleteMapping("/{id}")
@Transactional
    public void deletePosts(@PathVariable Long id){
     Post post= postRepository.getReferenceById(id);
     postRepository.delete(post);
}


}
