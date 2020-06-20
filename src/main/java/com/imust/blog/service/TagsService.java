package com.imust.blog.service;

import com.imust.blog.domain.po.Tag;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/20 19:32
 * Content:
 */
public interface TagsService {

    Boolean saveTag(Tag tag);

    List<Tag> findAllTag();

    Boolean deleteTag(Integer id);

    Tag findOneTagById(Integer id);
}
