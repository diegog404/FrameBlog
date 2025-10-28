package com.aluno.FrameBlog.services.impl;

import com.aluno.FrameBlog.models.User;
import com.aluno.FrameBlog.repositories.UserRepository;
import com.aluno.FrameBlog.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(final User user){

        User existingUser = userRepository.findByUsername(user.getName());

        if(Objects.nonNull(existingUser)){

            throw new RuntimeException("Existing user");
        }
        User entity = new User(user.getUserId(), user.getName(), user.getEmail(), user.getPassword(), user.getRole());
        User newUser = userRepository.save(entity);
        return new User(newUser.getUserId(), newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getRole());
    }

    @Override
    public List<User> getAll(){

        return userRepository.findAll();
    }

    @Override
    public User get(final Long id){

        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public User update(final Long id, final User user){

        User userUpdate = userRepository.findById(id).orElse(null);

        if(Objects.nonNull(userUpdate)){

            String passwordHash = passwordEncoder.encode(user.getPassword());
            userUpdate.setName(user.getName());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPassword(user.getPassword());
            userUpdate.setRole(passwordHash);
            userUpdate.setUsername(user.getUsername());
            return userRepository.save(userUpdate);
        }
        return  null;
    }

    @Override
    public void delete(final Long id){

        userRepository.deleteById(id);
    }
}
