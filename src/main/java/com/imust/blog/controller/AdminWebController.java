package com.imust.blog.controller;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.domain.po.Tag;
import com.imust.blog.domain.po.Type;
import com.imust.blog.service.BlogService;
import com.imust.blog.service.TagsService;
import com.imust.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/21 8:22
 * Content:
 */

@Controller
@RequestMapping("/admin")
public class AdminWebController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagsService tagsService;


    /**
     * 跳转新增页面
     * @return
     */
    @GetMapping("/blogs/input")
    public String gotoBlogInput(Model model){
        model.addAttribute("Blog", new Blog());
        List<Type> allType = typeService.findAllType();
        model.addAttribute("types", allType);
        return "admin/blogs-input";
    }

    /**
     * 跳转到博客首页
     * @param modelMap
     * @return
     */
    @GetMapping("/blogs")
    public String gotoBlog(ModelMap modelMap){

        List<Blog> blogList = blogService.findAllBlog();
        modelMap.put("blogs", blogList);

        return "admin/blogs";
    }

    
    /**
     * 跳转标签界面
     * @return
     */
    @GetMapping("/tags")
    public String goToTags(ModelMap modelMap){
        List<Tag> allTag = tagsService.findAllTag();
        modelMap.put("Tags", allTag);
        return "admin/tags";
    }

    /**
     * 跳转到分类管理
     */
    @RequestMapping("/types")
    public String gotoTypes(ModelMap modelMap){
        List<Type> allType = typeService.findAllType();

        modelMap.put("types", allType);
        return "admin/types";
    }

}
