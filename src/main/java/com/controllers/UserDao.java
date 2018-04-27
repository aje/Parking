package com.controllers;

import com.models.User;

import java.util.List;

public interface UserDao {
	public List<User> getUser(String queryString);
	public Boolean edit(int id, String[] para, String[] values);
	public User getOne(int id);
	public Boolean addUserToDB(User user);
	public Boolean delete(int id, int flag);
	public int isMobileExist(String mobile);
}
