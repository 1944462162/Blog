package com.imust.blog.dao;

import com.imust.blog.domain.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Author: wangJianBo
 * Date: 2020/6/20 19:34
 * Content:
 */
public interface TagDao extends JpaRepository<Tag,Integer>, JpaSpecificationExecutor<Tag> {
}
