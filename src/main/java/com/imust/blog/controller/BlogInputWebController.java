package com.imust.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 10:01
 * Content:
 */

@Controller
@RequestMapping("/admin")
public class BlogInputWebController {

    @GetMapping("/blogs/input")
    public String gotoBlogInput(){
        return "admin/blogs-input";
    }
}
