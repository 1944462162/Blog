package com.imust.blog.service.impl;

import com.imust.blog.dao.TagDao;
import com.imust.blog.domain.po.Tag;
import com.imust.blog.service.TagsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/20 19:33
 * Content:
 */

@Service
@Slf4j
public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagDao tagDao;

    @Override
    public Boolean saveTag(Tag tag) {
        try {
            tagDao.save(tag);
        } catch (Exception e) {
            log.error(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public List<Tag> findAllTag() {
        return tagDao.findAll();
    }

    @Override
    public Boolean deleteTag(Integer id) {
        try {
            tagDao.deleteById(id);
        } catch (Exception e) {
            log.error(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public Tag findOneTagById(Integer id) {
        return tagDao.getOne(id);
    }
}
