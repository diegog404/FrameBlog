package com.aluno.FrameBlog.services;

import com.aluno.FrameBlog.models.Tag;

import java.util.List;

public interface TagService {
    Tag save(Tag tag);

    List<Tag> getAll();

    Tag get(Long id);

    Tag update(Long id, Tag tag);

    void delete(Long id);
}
