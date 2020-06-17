package com.imust.blog.service.impl;

import com.imust.blog.dao.BlogDao;
import com.imust.blog.domain.po.Blog;
import com.imust.blog.service.BlogService;
import com.imust.blog.utils.Time;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 15:18
 * Content:
 */

@Service
@Slf4j
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;
    @Override
    public Boolean saveBlog(Blog blog) {
        Time time = new Time();
        try {
            blog.setCreateTime(time.getNowDate());
            blog.setUpdateTime(time.getNowDate());
            blogDao.save(blog);
        } catch (Exception e) {
            log.error("保存博客信息失败：" + e);
            return false;
        }
        return true;
    }

    @Override
    public List<Blog> findAllBlog() {
        return blogDao.findAll();
    }
}
