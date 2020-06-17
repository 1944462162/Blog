package com.imust.blog.controller;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Author: wangJianBo
 * Date: 2020/6/17 10:01
 * Content:
 */

@Controller
@RequestMapping("/admin")
public class BlogInputApiController {

    @Autowired
    private BlogService blogService;
    @PostMapping("/blogs/input/api")
    public String gotoBlogInput(Blog blog, RedirectAttributes attributes) {
        System.out.println(blog.toString());
        Boolean saveBlog = blogService.saveBlog(blog);
        if (saveBlog){
            attributes.addAttribute("message", "操作成功");
        } else {
            attributes.addAttribute("message", "操作失败");
        }
        return "redirect:/admin/blogs";
    }
}
