package com.ha.forum.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ForumData implements IForumData{
	private List<Forum> forums = new ArrayList<Forum>();
	private List<User> users = new ArrayList<>();

	@Override
	public User checkUser(String name, String password) {
		for (User user : users) {
			if (user.getUsername().equals(name) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}
