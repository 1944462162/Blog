package com.imust.blog.service.impl;

import com.imust.blog.dao.LoginDao;
import com.imust.blog.domain.po.User;
import com.imust.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 7:45
 * Content:
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;
    @Override
    public boolean findUser(User user) {
        List<User> users = loginDao.findUser(user.getUserName(), user.getPassWord());
        if (users.isEmpty()){
            return false;
        }
        return true;
    }
}
