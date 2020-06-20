package com.imust.blog.controller;

import com.imust.blog.domain.po.Tag;
import com.imust.blog.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/20 19:26
 * Content:
 */

@Controller
@RequestMapping("/admin")
public class TagsWebController {

    @Autowired
    private TagsService tagsService;
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
}
