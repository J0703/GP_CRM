package com.lanou.service.impl;

import com.lanou.dao.UserDao;
import com.lanou.service.UserService;

/**
 * Created by dllo on 17/10/24.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public boolean login(String name, String psw) {
        return userDao.login(name,psw);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
