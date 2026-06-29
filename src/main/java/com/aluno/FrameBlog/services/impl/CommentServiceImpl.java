package com.aluno.FrameBlog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluno.FrameBlog.models.Comment;
import com.aluno.FrameBlog.services.CommentService;
import com.aluno.FrameBlog.services.UserService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private UserService userService;
	
	@Override
	public Comment send(Comment comment) {
		
		comment.setUser(userService.get(comment.getUser().getUserId()));
		
		return comment;
	}
}
