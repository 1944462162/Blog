package com.imust.blog.controller.Reception;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/21 18:20
 * Content:
 */

@Controller
@RequestMapping("/blog")
public class SearchApiController {

    @Autowired
    private BlogService blogService;
    @RequestMapping("/search")
    public ModelAndView SearchAllBlog(String query,ModelAndView modelAndView){
        System.out.println(query);
        List<Blog> blogList = blogService.searchAllBlog(query);
        modelAndView.addObject("blogs", blogList);
        modelAndView.setViewName("search");
        return modelAndView;
    }
}
