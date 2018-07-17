package com.yanhuan.yhssm.controller;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.domain.condition.UserCondition;
import com.yanhuan.yhssm.domain.pojo.User;
import com.yanhuan.yhssm.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录控制器
 *
 * @author yanhuan1
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("login")
    public String login(User user, Model model,
                        HttpServletRequest request, HttpServletResponse response) {
        try {
            Preconditions.checkNotNull(user);
            Preconditions.checkArgument(StringUtils.isNotBlank(user.getUsername()), "用户名不能为空!");
            Preconditions.checkArgument(StringUtils.isNotBlank(user.getPassword()), "密码不能为空!");
            UserCondition userCondition = new UserCondition();
            userCondition.setUsername(user.getUsername());
            userCondition.setPassword(user.getPassword());
            User userByCondition = userService.getUserByCondition(userCondition);
            if (userByCondition != null) {
                request.getSession().setAttribute("username", user.getUsername());
                model.addAttribute("username", user.getUsername());
                return "success";
            } else {
                model.addAttribute("errorMsg", "用户名或密码不正确");
                return "fail";
            }
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "fail";
        }
    }


}
