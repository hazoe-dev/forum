package com.ha.forum.model;

import java.util.List;

public interface IForumData {
	User checkUser(String name, String password);
	
	List<User> getUsers();
	List<Forum> getForums();
}
