package com.apiintegration.apiintegration.controller;

import com.apiintegration.apiintegration.model.Post;
import com.apiintegration.apiintegration.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> findAll() {
        logger.info("Fetching all posts");
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Integer id) {
        logger.info("Fetching post with id: {}", id);
        return postService.findPostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        logger.info("Creating a new post: {}", post);
        return postService.createPost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Integer id) {
        logger.info("Deleting post with id: {}", id);
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        logger.info("Updating post with id {}: {}", id, post);
        return postService.updatePost(id, post);
    }
}
