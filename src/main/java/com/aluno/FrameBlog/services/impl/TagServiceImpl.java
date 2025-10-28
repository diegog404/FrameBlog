package com.aluno.FrameBlog.services.impl;

import com.aluno.FrameBlog.models.Tag;
import com.aluno.FrameBlog.repositories.TagRepository;
import com.aluno.FrameBlog.services.TagService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag save(Tag tag){

        Tag existingTag = tagRepository.findById(tag.getTagId()).orElse(null);

        if(Objects.nonNull(existingTag)){

            throw new RuntimeException("Existing tag");
        }
        Tag entity = new Tag(tag.getTagId(), tag.getName());
        return tagRepository.save(entity);
    }

    @Override
    public List<Tag> getAll(){

        return tagRepository.findAll();
    }

    @Override
    public Tag get(final Long id){

        return tagRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tag not found"));
    }

    @Override
    public Tag update(final Long id, final Tag tag){

        Tag tagUpdate = tagRepository.findById(id).orElse(null);

        if(Objects.nonNull(tagUpdate)){

            tagUpdate.setName(tag.getName());
            return tagRepository.save(tagUpdate);
        }
        return null;
    }

    @Override
    public void delete(final Long id){

        tagRepository.deleteById(id);
    }
}
