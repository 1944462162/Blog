package com.imust.blog.dao;

import com.imust.blog.domain.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/20 19:34
 * Content:
 */
public interface TagDao extends JpaRepository<Tag,Integer>, JpaSpecificationExecutor<Tag> {

    @Query(value = "from Tag where tagName = ?1")
    List<Tag> findOneTagByName(String tagName);
}
