package com.imust.blog.controller;

import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Author: wangJianBo
 * Date: 2020/6/16 15:18
 * Content:
 */

//http://localhost:8080/web/admin/login
@Controller
@RequestMapping("/admin")
public class LoginController {

    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String adminLogin(@RequestParam String username, @RequestParam String password, HttpSession session){
        if (!StringUtils.isEmpty(username)){
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            return "admin/index";
        } else {
            return "redirect: /admin";
        }
    }
}
