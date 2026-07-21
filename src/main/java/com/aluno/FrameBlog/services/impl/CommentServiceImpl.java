package com.aluno.FrameBlog.services.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluno.FrameBlog.models.Comment;
import com.aluno.FrameBlog.services.CommentService;
import com.aluno.FrameBlog.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.*;
import org.springframework.amqp.core.AmqpTemplate;


@Service
public class CommentServiceImpl implements CommentService {
   
	@Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private UserService userService;

    @Value("${FrameBlog.rabbitmq.exchange}")
    private String exchange;

    @Value("${FrameBlog.rabbitmq.routingkey}")
    private String routingkey;

    @Override
    public Comment send(Comment comment) {
        comment.setUser(userService.get(comment.getUser().getUserId()));

        amqpTemplate.convertAndSend(exchange, routingkey, comment);
        System.out.println("Send msg = " + comment);
        return comment;
    }
}
