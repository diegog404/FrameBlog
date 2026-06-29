package com.aluno.FrameBlog.services.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluno.FrameBlog.models.Post;
import com.aluno.FrameBlog.repositories.PostRepository;
import com.aluno.FrameBlog.services.PostService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Post save(final Post post) {
		
		Post existingPost = postRepository.findById(post.getPostId()).orElse(null);
		
		if(Objects.nonNull(existingPost)) {
			
			throw new RuntimeException("Existing post");
		}
		
		Post entity = new Post(post.getPostId(), post.getTitle(), post.getContent(), 
				post.getDate(), post.getUserId());
		
		return postRepository.save(entity);
	}
	
	@Override
	public List<Post> getAll(){
		
		return postRepository.findAll();
	}
	
	@Override
	public Post get(final Long id) {
		
		return postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found"));
		
	}
	
	@Override
	public Post update(final Long id, final Post post) {
		
		Post postUpdate = postRepository.findById(id).orElse(null);
		
		if(Objects.nonNull(postUpdate)) {
			
			postUpdate.setContent(post.getContent());
			postUpdate.setTitle(post.getTitle());
			postUpdate.setDate(post.getDate());
			postUpdate.setPostId(post.getPostId());
			
			return postRepository.save(postUpdate);
		}
		
		return null;
	}
	
	@Override
	public void delete(final Long id) {
		
		postRepository.deleteById(id);
	}
}
