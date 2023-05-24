package com.example.practice_crud.post;

import java.util.List;

public interface PostRepositiry {
    List<PostDto> findAll();
    PostDto findById(int id);
    boolean save(PostDto dto);
    boolean delete(int id);
    boolean update(int id, PostDto dto);
}
