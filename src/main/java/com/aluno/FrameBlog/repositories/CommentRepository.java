package com.aluno.FrameBlog.repositories;

import com.aluno.FrameBlog.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
