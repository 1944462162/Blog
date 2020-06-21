package com.imust.blog.controller.Reception;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.domain.po.Type;
import com.imust.blog.service.BlogService;
import com.imust.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/21 10:08
 * Content:
 */

@Controller
@RequestMapping("/blog")
public class TypeApiController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    /**
     * 根据分类查询博客
     */
    @GetMapping("/api/findAllBlogByType")
    public String findAllBlogByType(@RequestParam("typeName") String typeName, Model model){

        List<Blog> allBlogByType = blogService.findAllBlogByTypeName(typeName);
        List<Type> allType = typeService.findAllType();
        model.addAttribute("blogs", allBlogByType);
        model.addAttribute("types",allType);
        return "types";
    }
}
