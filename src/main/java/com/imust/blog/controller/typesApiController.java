package com.imust.blog.controller;

import com.imust.blog.domain.po.Blog;
import com.imust.blog.domain.po.Type;
import com.imust.blog.service.TypeService;
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
 * Date: 2020/6/18 15:51
 * Content:
 */

@Controller
@RequestMapping("/admin")
public class typesApiController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/types/input")
    public String gotoTypesInput(Model model){
        model.addAttribute("Type", new Type());
        return "admin/types-input";
    }

    @PostMapping("/types/input/save")
    public String saveTypes(Type type, RedirectAttributes attributes, ModelMap modelMap){
        System.out.println(type.toString());
        Boolean operationType = typeService.saveType(type);

        List<Type> allType = typeService.findAllType();

        modelMap.put("types", allType);

        if (operationType){
            attributes.addAttribute("message", "操作成功");
        } else {
            attributes.addAttribute("message", "操作失败");
        }
        return "admin/types";
    }

    @GetMapping("/types/delete/api")
    public String deleteType(@RequestParam("id") Integer id, RedirectAttributes attributes){
        System.out.println("进入delete" + id);
        Boolean deleteBlog = typeService.deleteType(id);
        if (deleteBlog){
            attributes.addAttribute("message", "操作成功");
        } else {
            attributes.addAttribute("message", "操作失败");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/update/api")
    public String updateType(@RequestParam("id") Integer id, Model model){
        Type type = typeService.findOneTypeById(id);
        model.addAttribute("Type", type);
        return "admin/types-input";
    }
}
