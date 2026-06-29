package com.aluno.FrameBlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aluno.FrameBlog.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String login);
}
