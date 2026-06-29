package com.aluno.FrameBlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aluno.FrameBlog.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
