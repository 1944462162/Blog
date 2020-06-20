package com.imust.blog.controller;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/19 7:48
 * Content:
 */

@Controller
@RequestMapping("/blog")
public class IndexWebController {

    @Autowired
    private BlogService blogService;

    /**
     * 前往博客首页
     * @param modelMap
     * @return
     */
    @RequestMapping("/index")
    public String gotoIndex(ModelMap modelMap){
        List<Blog> blogList = blogService.findAllBlog();
        modelMap.put("blogs", blogList);
        return "index";
    }
}
