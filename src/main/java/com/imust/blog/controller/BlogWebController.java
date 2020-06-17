package com.imust.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 9:13
 * Content:
 */
@Controller
@RequestMapping("/admin")
public class BlogWebController {

    @GetMapping("/blogs")
    public String gotoBlog(){
        return "admin/blogs";
    }
}
