package com.aluno.FrameBlog.services.v2;

import java.util.List;

import com.aluno.FrameBlog.models.v2.UserV2;

public interface UserServiceV2 {
	
	UserV2 save(UserV2 userV2);

	List<UserV2> getAll();

	UserV2 update(Long id, UserV2 userV2);

	void delete(Long id);

	UserV2 get(Long id);
}
