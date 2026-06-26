package com.aluno.FrameBlog.services;

import java.util.List;

import com.aluno.FrameBlog.models.Tag;

public interface TagService {

	Tag save(Tag tag);

	List<Tag> getAll();

	Tag get(Long id);

	Tag update(Long id, Tag tag);

	void delete(Long id);

}
