package com.dao;

import com.models.User;

import java.util.List;

public interface UserDao {
	public Boolean add(User user);
	public Boolean edit(User user);
	public Boolean delete(int id, int flag);
	public User getOne(int id);
	public List<User> getUser(String queryString);
	public int isMobileExist(String mobile);
}
