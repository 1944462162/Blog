package com.imust.blog.service;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.domain.po.Type;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 15:16
 * Content:
 */
public interface BlogService {

    Boolean saveBlog(Blog blog);

    List<Blog> findAllBlog();

    Boolean deleteBlog(Long id);

    Blog findOneBlogById(Long id);

    Boolean upDateBlog(Blog blog);

    List<Blog> findAllBlogByTypeName(String typeName);

    List<Blog> findAllBlogByTagName(String tagName);

    List<Blog> searchAllBlog(String keyword);
}
