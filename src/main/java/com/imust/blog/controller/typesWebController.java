package com.imust.blog.controller;

import com.imust.blog.domain.po.Type;
import com.imust.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/6/18 15:36
 * Content:
 */

@Controller
@RequestMapping("/admin")
public class typesWebController {


    @Autowired
    private TypeService typeService;
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
