package com.imust.blog.controller.Reception;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.domain.po.Tag;
import com.imust.blog.domain.po.Type;
import com.imust.blog.service.BlogService;
import com.imust.blog.service.TagsService;
import com.imust.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagsService tagsService;

    @RequestMapping("/search")
    public ModelAndView SearchAllBlog(String query,ModelAndView modelAndView){
        System.out.println(query);
        List<Blog> blogList = blogService.searchAllBlog(query);
        modelAndView.addObject("blogs", blogList);
        modelAndView.setViewName("search");
        return modelAndView;
    }

    @GetMapping("/page")
    public String SearchBlogByPage(ModelMap modelMap,@RequestParam Integer page){
        System.out.println(page);
        List<Blog> blogList = blogService.getBlogByPage(page,true);
        List<Type> allType = typeService.findAllType();
        List<Tag> allTag = tagsService.findAllTag();
        modelMap.put("types", allType);
        modelMap.put("blogs", blogList);
        modelMap.put("tags", allTag);
        modelMap.put("pages", page);
        return "/index";
    }
}
