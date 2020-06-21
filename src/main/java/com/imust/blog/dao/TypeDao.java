package com.imust.blog.dao;


import com.imust.blog.domain.po.Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/18 16:03
 * Content:
 */
public interface TypeDao extends JpaRepository<Type,Integer>, JpaSpecificationExecutor<Type> {

    @Query(value = "from Type where typeName = ?1")
    List<Type> findOneTypeByName(String typeName);
}
