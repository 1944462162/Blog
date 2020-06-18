package com.imust.blog.service;

import com.imust.blog.domain.po.Type;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/18 16:01
 * Content:
 */
public interface TypeService {

    Boolean saveType(Type type);

    List<Type> findAllType();

    Boolean deleteType(Integer id);

    Type findOneTypeById(Integer id);
}
