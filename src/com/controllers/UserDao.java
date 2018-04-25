package com.controllers;

import java.util.List;

import com.models.User;

public interface UserDao {
	public List<User> getUser(String queryString);
	public Boolean edit(int id, String[] para, String[] values);
	public User getOne(int id);
}
