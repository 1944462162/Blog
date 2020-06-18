package com.imust.blog.controller;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 9:13
 * Content:
 */
@Controller
@RequestMapping("/admin")
public class BlogWebController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public String gotoBlog(ModelMap modelMap){

        List<Blog> blogList = blogService.findAllBlog();
        modelMap.put("blogs", blogList);

        return "admin/blogs";
    }
}
