package com.imust.blog.dao;

import com.imust.blog.domain.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 7:48
 * Content:
 */
public interface LoginDao extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    @Query(value = "from User where userName = ?1 and passWord = ?2")
    List<User> findUser(String userName, String passWord);
}
