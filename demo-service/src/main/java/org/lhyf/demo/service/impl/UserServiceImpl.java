package org.lhyf.demo.service.impl;

import org.lhyf.demo.mapper.TUserMapper;
import org.lhyf.demo.pojo.TUser;
import org.lhyf.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/****
 * @author YF
 * @date 2018-06-14 10:14
 * @desc UserServiceImpl
 *
 **/

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public TUser selectByName(String name) {
//        userMapper.selectByName(name);
        return null;
    }
}
