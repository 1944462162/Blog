package com.imust.blog.controller;

import com.imust.blog.domain.po.Tag;
import com.imust.blog.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/20 20:00
 * Content:
 */

@Controller
@RequestMapping("/admin")
public class TagsApiController {

    @Autowired
    private TagsService tagsService;

    @RequestMapping("/tags/input")
    public String gotoTypesInput(Model model){
        model.addAttribute("Tags", new Tag());
        return "admin/tags-input";
    }

    /**
     * 保存更新标签
     * @param tag
     * @param attributes
     * @param modelMap
     * @return
     */
    @PostMapping("/tags/input/save")
    public String saveTags(Tag tag, RedirectAttributes attributes, ModelMap modelMap){
        Boolean operationType = tagsService.saveTag(tag);
        List<Tag> allTag = tagsService.findAllTag();
        modelMap.put("Tags", allTag);
        if (operationType){
            attributes.addAttribute("message", "操作成功");
        } else {
            attributes.addAttribute("message", "操作失败");
        }
        return "admin/tags";
    }

    @GetMapping("/tags/delete/api")
    public String deleteTags(@RequestParam("id") Integer id, RedirectAttributes attributes){
        System.out.println("进入delete" + id);
        Boolean deleteTags = tagsService.deleteTag(id);
        if (deleteTags){
            attributes.addAttribute("message", "操作成功");
        } else {
            attributes.addAttribute("message", "操作失败");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/update/api")
    public String updateTags(@RequestParam("id") Integer id, Model model){
        Tag tag = tagsService.findOneTagById(id);
        model.addAttribute("Tags", tag);
        return "admin/tags-input";
    }
}
