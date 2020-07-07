package com.imust.blog.config.intercepors;

import com.imust.blog.domain.po.User;
import com.imust.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Author: wangJianBo
 * Date: 2020/6/16 15:10
 * Content:
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = new User();
        user.setUserName((String) session.getAttribute("username"));
        user.setPassWord((String) session.getAttribute("password"));
        System.out.println(loginService.findUser(user));
        if (!loginService.findUser(user)) {
            response.sendRedirect("/admin");
            return false;
        } else{
            return true;
        }
    }
}
