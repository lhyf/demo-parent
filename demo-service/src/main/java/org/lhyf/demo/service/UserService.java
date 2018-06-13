package org.lhyf.demo.service;

import org.lhyf.demo.dao.UserDao;
import org.lhyf.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findByName(String name){
        return userDao.findByName(name);
    }

}
