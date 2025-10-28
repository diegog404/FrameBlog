package com.aluno.FrameBlog.services;

import com.aluno.FrameBlog.models.Post;

import java.util.List;

public interface PostService{
    Post save(Post post);


    List<Post> getAll();

    Post get(Long id);

    Post update(Long id, Post post);

    void delete(Long id);
}
