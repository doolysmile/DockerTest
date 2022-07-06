package com.example.kch.dockertest.controller;

import com.example.kch.dockertest.domain.Post;
import com.example.kch.dockertest.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final ItemRepository itemRepository;

    @GetMapping("/post/add")
    public ResponseEntity<Object> addPost(@RequestParam("title") String title, @RequestParam("content") String content){
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        return ResponseEntity.status(HttpStatus.OK).body(itemRepository.save(post).getPostId());
    }

    @GetMapping("/post/list")
    public ResponseEntity<List<Post>> getPosts(){
        List<Post> posts = itemRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }
}
