package com.imust.blog.dao;


import com.imust.blog.domain.po.Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Author: wangJianBo
 * Date: 2020/6/18 16:03
 * Content:
 */
public interface TypeDao extends JpaRepository<Type,Integer>, JpaSpecificationExecutor<Type> {
}
