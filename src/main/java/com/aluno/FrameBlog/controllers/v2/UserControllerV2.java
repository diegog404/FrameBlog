package com.aluno.FrameBlog.controllers.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aluno.FrameBlog.models.v2.UserV2;
import com.aluno.FrameBlog.services.v2.UserServiceV2;


@RestController
@RequestMapping(path = "/v2/users")
public class UserControllerV2 {

	@Autowired
	private UserServiceV2 userServiceV2;
	
	@PostMapping(path = "/save")
	private @ResponseBody UserV2 save(@RequestBody UserV2 userV2) {
		
		return userServiceV2.save(userV2);
	}
	
	@GetMapping(path = "/getAll")
	private @ResponseBody List<UserV2> getAll(){
		
		return userServiceV2.getAll();
	}
	
	@GetMapping(path = "/get")
	private @ResponseBody UserV2 get(@RequestParam final Long id, @RequestBody UserV2 userV2) {
		
		return userServiceV2.get(id);
	}
	
	@PostMapping(path = "/update")
	private @ResponseBody UserV2 update(@RequestParam final Long id, @RequestBody UserV2 userV2) {
		
		return userServiceV2.update(id, userV2);
	}
	
	@DeleteMapping(path = "/delete")
	private void delete(@RequestParam final Long id) {
		
		userServiceV2.delete(id);
	}
	
	
}
