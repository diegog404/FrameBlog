package com.aluno.FrameBlog.services.v2;

import com.aluno.FrameBlog.models.User;
import com.aluno.FrameBlog.models.v2.UserV2;

import java.util.List;

public interface UserServiceV2 {

    List<UserV2> getAll();

    UserV2 save(final UserV2 user);

    void delete(final Long id);

    UserV2 update(final Long id, final UserV2 user);

    UserV2 get(final Long id);
}
