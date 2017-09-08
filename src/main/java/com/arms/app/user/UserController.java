package com.arms.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arms.domain.entity.User;
import com.arms.domain.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping("todos")
	public List<User> list() {
		return userRepository.findAll();
	}

	@RequestMapping(value = "todos", method = RequestMethod.POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
}
