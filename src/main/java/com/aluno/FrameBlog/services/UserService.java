package com.aluno.FrameBlog.services;

import java.util.List;

import com.aluno.FrameBlog.models.User;

public interface UserService {

	User save(User user);

	List<User> getAll();

	User update(Long id, User user);

	void delete(Long id);

	User get(Long id);
}
