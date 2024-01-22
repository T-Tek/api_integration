package com.apiintegration.apiintegration.service;

import com.apiintegration.apiintegration.model.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

//    @Value("${BASE_URL}")
//    private String BASE_URL;

    private final RestClient restClient;

    public List<Post> findAll(){
        log.info("Fetching all posts.");
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});
    }

    public Post findPostById(Integer id){
        log.info("Fetching post with id: {}", id);
        return restClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .body(Post.class);
    }

    public Post createPost(Post post){
        log.info("Creating a new post: {}", post);
        return restClient.post()
                .uri("/posts/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);
    }

    public Post updatePost(Long id, Post post){
        log.info("Updating post with id {}: {}", id, post);
        return restClient.put()
                .uri("/posts/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);
    }

    public void deletePost(Integer id){
        log.info("Deleting post with id: {}", id);
        restClient.delete()
                .uri("/posts/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }
}
