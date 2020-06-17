package com.imust.blog.service;

import com.imust.blog.domain.po.User;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 7:42
 * Content:
 */
public interface LoginService {
    boolean findUser(User user);
}
