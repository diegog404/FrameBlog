package com.aluno.FrameBlog.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Comment")

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    private String content;

    private Date date;

    @ManyToOne
    private Long postId;

    @ManyToOne
    private Long userId;

    public Comment() {
    }

    public Comment(final Long userId, final Long postId, final Date date, final String content, final Long commentId) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.content = content;
        this.commentId = commentId;
    }
}
