package com.imust.blog.config.intercepors;

import com.imust.blog.domain.po.User;
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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = new User();
        user.setUserName((String) session.getAttribute("username"));
        user.setPassWord((String) session.getAttribute("password"));
        System.out.println(user);
        if (StringUtils.isEmpty(user)) {
            response.sendRedirect("/admin/login");
            return false;
        } else{
            return true;
        }
    }
}
