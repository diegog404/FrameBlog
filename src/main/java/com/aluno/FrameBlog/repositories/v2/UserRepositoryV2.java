package com.aluno.FrameBlog.repositories.v2;

import com.aluno.FrameBlog.models.User;
import com.aluno.FrameBlog.models.v2.UserV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryV2 extends JpaRepository<UserV2, Long> {

    UserV2 findByUsername(String login);
}
