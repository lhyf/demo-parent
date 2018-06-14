package org.lhyf.demo.service;

import org.lhyf.demo.pojo.TUser;

public interface UserService {


    TUser selectByName(String name);

}
