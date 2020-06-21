package com.imust.blog.controller.Reception;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.domain.po.Tag;
import com.imust.blog.service.BlogService;
import com.imust.blog.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/21 15:11
 * Content:
 */

@Controller
@RequestMapping("/blog")
public class TagApiController {

    @Autowired
    private TagsService tagsService;

    @Autowired
    private BlogService blogService;

    /**
     * 根据分类查询博客
     */
    @GetMapping("/api/findAllBlogByTag")
    public String findAllBlogByTag(@RequestParam("tagName") String tagName, Model model){

        List<Blog> allBlogByTag = blogService.findAllBlogByTagName(tagName);
        List<Tag> allTag = tagsService.findAllTag();
        model.addAttribute("blogs", allBlogByTag);
        model.addAttribute("tags",allTag);
        return "tags";
    }
}
