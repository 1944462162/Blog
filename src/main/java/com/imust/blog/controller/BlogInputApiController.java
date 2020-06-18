package com.imust.blog.controller;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.service.BlogService;
import com.imust.blog.utils.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    /**
     * 编写论文进行论文的提交
     * @param blog
     * @param attributes
     * @param modelMap
     * @return
     */
    @PostMapping("/blogs/input/api")
    public String gotoBlogInput(Blog blog, RedirectAttributes attributes, ModelMap modelMap) {
        System.out.println(blog.toString());

        Boolean operationBlog = blogService.saveBlog(blog);

        List<Blog> blogList = blogService.findAllBlog();

        modelMap.put("blogs", blogList);

        if (operationBlog){
            attributes.addAttribute("message", "操作成功");
        } else {
            attributes.addAttribute("message", "操作失败");
        }
        return "admin/blogs";
    }

    @GetMapping("/blogs/delete/api")
    public String deleteBlog(@RequestParam("id") Long id, RedirectAttributes attributes){
        System.out.println("进入delete" + id);
        Boolean deleteBlog = blogService.deleteBlog(id);
        if (deleteBlog){
            attributes.addAttribute("message", "操作成功");
        } else {
            attributes.addAttribute("message", "操作失败");
        }
        return "redirect:/admin/blogs";
    }
    @GetMapping("/blogs/update/api")
    public String updateBlog(@RequestParam("id") Long id, Model model){
        Blog blog = blogService.findOneBlogById(id);
        model.addAttribute("Blog", blog);
        return "admin/blogs-input";
    }

}
