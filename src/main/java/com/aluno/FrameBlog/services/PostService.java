package com.aluno.FrameBlog.services;

import java.util.List;

import com.aluno.FrameBlog.models.Post;

public interface PostService {

	Post save(Post post);

	List<Post> getAll();

	Post get(Long id);

	Post update(Long id, Post post);

	void delete(Long id);

}
