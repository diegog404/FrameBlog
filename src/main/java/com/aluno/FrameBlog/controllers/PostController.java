package com.aluno.FrameBlog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aluno.FrameBlog.models.Post;
import com.aluno.FrameBlog.services.PostService;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping(path = "/save")
	private @ResponseBody Post save(@RequestBody Post post) {
		
		return postService.save(post);
	}
	
	@GetMapping(path = "/getAll")
	private @ResponseBody List<Post> getAll(){
		
		return postService.getAll();
	}
	
	@GetMapping(path = "/get")
	private @ResponseBody Post get(@RequestParam final Long id) {
		
		return postService.get(id);
	}
	
	@PostMapping(path = "/update")
	private @ResponseBody Post update(@RequestParam final Long id, @RequestBody Post post) {
		
		return postService.update(id, post);
	}
	
	@DeleteMapping(path = "/delete")
	private void delete(@RequestParam final Long id) {
		
		postService.delete(id);
	}
}
