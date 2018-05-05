package com.services;

import com.dao.UserDao;
import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean add(User user) {
        return this.userDao.add(user);
    }

    public boolean update(User user, int id) {
        return this.userDao.save(user, id);
    }

    public Boolean delete(int id, Boolean flag) {
        return this.userDao.delete(id);
    }

    public List<User> get(String queryString) {
        return this.userDao.get(queryString);
    }

    public Boolean isMobileExist(String mobile) {
        return this.userDao.isMobileExist(mobile);
    }
}
