package com.yanhuan.yhssm.interceptors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 *
 * @author yanhuan1
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * Handler执行之前调用这个方法
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取请求的URL
        String url = httpServletRequest.getRequestURI();
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        if (url.indexOf("login") >= 0) {
            return true;
        }
        //获取Session
        HttpSession session = httpServletRequest.getSession();
        String username = (String) session.getAttribute("username");
        if (StringUtils.isNotBlank(username)) {
            return true;
        }
        //不符合条件的，跳转到登录界面
        httpServletRequest.getRequestDispatcher("/WEB-INF/login.jsp").forward(httpServletRequest, httpServletResponse);
        return false;
    }

    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }


    /**
     * Handler执行完成之后调用这个方法
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
