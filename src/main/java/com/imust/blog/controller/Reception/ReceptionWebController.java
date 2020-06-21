package com.imust.blog.controller.Reception;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.domain.po.Type;
import com.imust.blog.service.BlogService;
import com.imust.blog.service.TypeService;
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
public class ReceptionWebController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    /**
     * 前往博客首页
     * @param modelMap
     * @return
     */
    @RequestMapping("/index")
    public String gotoIndex(ModelMap modelMap){
        List<Blog> blogList = blogService.findAllBlog();
        List<Type> allType = typeService.findAllType();
        modelMap.put("types", allType);
        modelMap.put("blogs", blogList);
        return "index";
    }

    /**
     * 点击导航栏的分类
     * @param modelMap
     * @return
     */
    @RequestMapping("/types")
    public String gotoType(ModelMap modelMap){
        List<Type> allType = typeService.findAllType();
        List<Blog> allBlog = blogService.findAllBlog();
        modelMap.addAttribute("blogs", allBlog);
        modelMap.put("types", allType);
        return "types";
    }

}
