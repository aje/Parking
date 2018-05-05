package com.dao;

import com.models.User;

import java.util.List;

public interface UserDao {
	Boolean add(User user);
	Boolean save(User user, int id);
	Boolean save(User user);
	Boolean delete(int id);
	User get(int id);
	List<User> get(String queryString);
	Boolean isMobileExist(String mobile);
}
