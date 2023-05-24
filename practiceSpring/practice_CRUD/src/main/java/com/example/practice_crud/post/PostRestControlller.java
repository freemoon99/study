package com.example.practice_crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("rest/post")
public class PostRestControlller {
    private static final Logger logger = LoggerFactory.getLogger(PostRestControlller.class);
    private final PostService postService;

    public PostRestControlller(@Autowired PostService postService){
        this.postService = postService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    @GetMapping()
    public List<PostDto> restPostAll(){
        logger.info("in read post all");
        return this.postService.readPostAll();
    }

    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id){
        logger.info("in read post");
        return this.postService.readPost(id);
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable("id") int id, @RequestBody PostDto postDto){
        logger.info("target id: "+id);
        logger.info("update content: "+postDto);
        this.postService.updatePost(id, postDto);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id) {
        this.postService.deletePost(id);
    }
}
