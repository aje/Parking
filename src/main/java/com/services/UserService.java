package com.services;

import com.dao.UserDao;
import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public boolean add(User user) {
        return this.userDao.addUser(user);
    }

    @Transactional
    public boolean update(User user, int id) {
        return  this.userDao.editUser(user,id);
    }

    @Transactional
    public Boolean delete(int id, Boolean flag) {
        return this.userDao.deleteUser(id, flag);
    }
    @Transactional
    public User getOne(int id) {
        return this.userDao.getOneUser(id);
    }
    @Transactional
    public List<User> get(String queryString) {
        return this.userDao.getUser(queryString);
    }
    @Transactional
    public Boolean isMobileExist(String mobile) {
        return this.userDao.isMobileExistUser(mobile);
    }
}
