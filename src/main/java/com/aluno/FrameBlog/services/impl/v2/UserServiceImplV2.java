package com.aluno.FrameBlog.services.impl.v2;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aluno.FrameBlog.models.v2.UserV2;
import com.aluno.FrameBlog.repositories.v2.UserRepositoryV2;
import com.aluno.FrameBlog.services.v2.UserServiceV2;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImplV2 implements UserServiceV2 {
	
	@Autowired
	private UserRepositoryV2 userRepositoryV2;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserV2 save(final UserV2 userV2) {
		
		UserV2 existingUser = userRepositoryV2.findByUsername(userV2.getUsername());
		
		if(Objects.nonNull(existingUser)) {
			
			throw new RuntimeException("Existing User");
		}
		String passwordHash = passwordEncoder.encode(userV2.getPassword());
		
		UserV2 entity = new UserV2(userV2.getUserId(), userV2.getName(), 
				userV2.getEmail(), passwordHash, userV2.getRole(), userV2.getUsername());
		
		UserV2 newUser = userRepositoryV2.save(entity);
		
		return new UserV2(newUser.getUserId(), newUser.getName(), newUser.getEmail(), 
				newUser.getPassword(), newUser.getRole(), newUser.getUsername());
	}

	@Override
	public List<UserV2> getAll() {

		return userRepositoryV2.findAll();
	}
	
	@Override
	public UserV2 get(final Long id) {

		return userRepositoryV2.findById(id).orElseThrow(() 
				-> new EntityNotFoundException("User not found"));
	}

	@Override
	public UserV2 update(final Long id, final UserV2 userV2) {

		UserV2 userUpdate = userRepositoryV2.findById(id).orElse(null);
		
		if(Objects.nonNull(userUpdate)) {
			
			String passwordHash = passwordEncoder.encode(userV2.getPassword());
			userUpdate.setName(userV2.getName());
			userUpdate.setUsername(userV2.getUsername());
			userUpdate.setEmail(userV2.getEmail());
			userUpdate.setRole(userV2.getRole());
			userUpdate.setPassword(passwordHash);
			
			return userRepositoryV2.save(userUpdate);
		}
		
		return null;
	}

	@Override
	public void delete(Long id) {

		userRepositoryV2.deleteById(id);
	}

}
