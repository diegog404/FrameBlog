package com.aluno.FrameBlog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aluno.FrameBlog.models.Comment;
import com.aluno.FrameBlog.services.CommentService;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@PostMapping(path = "/save")
	private @ResponseBody Comment save(@RequestBody Comment comment) {
		
		return commentService.send(comment);
	}
}
