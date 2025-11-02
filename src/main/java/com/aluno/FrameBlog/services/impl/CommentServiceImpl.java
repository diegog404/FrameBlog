package com.aluno.FrameBlog.services.impl;

import com.aluno.FrameBlog.models.Comment;
import com.aluno.FrameBlog.services.CommentService;
import com.aluno.FrameBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private UserService userServiceV2;

    public Comment send(Comment comment){

        comment.setUser(userServiceV2.get(comment.getUser().getUserId()));
        return comment;
    }
}
