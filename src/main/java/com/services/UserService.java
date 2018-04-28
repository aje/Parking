package com.services;

import com.dao.UserDao;
import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void addUser(User user) {
        this.userDao.add(user);
    }

    @Transactional
    public void updateUser(User user) {
        this.userDao.edit(user);
    }
}
