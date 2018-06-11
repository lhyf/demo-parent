package org.lhyf.demo.dao;

import org.apache.shiro.authc.Account;
import org.lhyf.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao  extends JpaRepository<User, Integer> {

    User findByName(String name);
}
