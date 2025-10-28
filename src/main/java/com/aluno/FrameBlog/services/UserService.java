package com.aluno.FrameBlog.services;

import com.aluno.FrameBlog.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User save(User user);

    User update(Long id);

    void delete(Long id);

    User update(Long id, User user);

    User get(Long id);
}
