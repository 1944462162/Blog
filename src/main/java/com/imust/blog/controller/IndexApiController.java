package com.imust.blog.controller;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author: wangJianBo
 * Date: 2020/6/19 8:06
 * Content:
 */

@Controller
@RequestMapping("/blog")
public class IndexApiController {

    @Autowired
    private BlogService blogService;

    /**
     * 进入博客查看界面
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/api")
    public String blogDetails(@RequestParam("id") Long id, ModelMap modelMap){
        Blog blog = blogService.findOneBlogById(id);

        blog.setViews(blog.getViews() + 1L);

        Boolean aBoolean = blogService.saveBlog(blog);
        System.out.println(aBoolean);
        modelMap.put("blog", blog);
        return "blog";
    }
}
