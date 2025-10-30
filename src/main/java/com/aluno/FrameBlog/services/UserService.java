package com.aluno.FrameBlog.services;

import com.aluno.FrameBlog.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User save(final User user);

    void delete(final Long id);

    User update(final Long id, final User user);

    User get(final Long id);
}
