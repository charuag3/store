package com.store.dao;

import java.util.List;

import com.store.entity.User;

public interface UserDAO {

	User getUser(String userName);
	List<User> getAllUsers();
	void addUser(User user);
	boolean updateUser(User user);
	void deleteUser(String username);
	

}
