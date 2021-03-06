package com.rest.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	@Autowired
	private UserDao userDao;

	@GetMapping("/users")
	public List<User> retrievAllUsers() {
		return userDao.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return userDao.findOne(id);
	}

	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		User savedUser = userDao.save(user);
	}
}
