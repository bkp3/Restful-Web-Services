package com.rest.webservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 5;
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Kohli", new Date()));
		users.add(new User(3, "Raina", new Date()));
		users.add(new User(4, "Mahi", new Date()));
		users.add(new User(5, "Sam", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == 0) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;

	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

}
