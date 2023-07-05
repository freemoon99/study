package com.example.practice_crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceSimple implements PostService{
    private static final Logger looger = LoggerFactory.getLogger(PostServiceSimple.class);
    private final PostRepositiry postRepositiry;
    public PostServiceSimple(@Autowired PostRepositiry postRepositiry) {
        this.postRepositiry = postRepositiry;
    }

    @Override
    public void createPost(PostDto dto) {
        //TODO
        if(!this.postRepositiry.save(dto)){
            throw new RuntimeException("save failed");
        }
    }

    @Override
    public List<PostDto> readPostAll() {
        return this.postRepositiry.findAll();
    }

    @Override
    public PostDto readPost(int id) {
        return this.postRepositiry.findById(id);
    }

    @Override
    public void updatePost(int id, PostDto dto) {
        this.postRepositiry.update(id, dto);
    }

    @Override
    public void deletePost(int id) {
        this.postRepositiry.delete(id);
    }
}
