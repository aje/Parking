package com.dao;

import com.models.User;

import java.util.List;

public interface UserDao {
	Boolean addUser(User user);
	Boolean editUser(User user, int id);
	Boolean deleteUser(int id, Boolean flag);
	User getOneUser(int id);
	List<User> getUser(String queryString);
	Boolean isMobileExistUser(String mobile);
}
