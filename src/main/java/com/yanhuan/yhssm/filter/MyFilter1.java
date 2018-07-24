package com.yanhuan.yhssm.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 第一个过滤器
 */
public class MyFilter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String username = (String) servletRequest.getAttribute("username");
        if ("caian".equals(username)) {
            System.out.println("MyFilter1 doFilter username" + username);
            servletRequest.setAttribute("username", "yanhuan");
        } else {
            servletRequest.setAttribute("username", "yanhuan");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
