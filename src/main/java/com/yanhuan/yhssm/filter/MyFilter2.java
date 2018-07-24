package com.yanhuan.yhssm.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 第一个过滤器
 */
public class MyFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String id = servletRequest.getParameter("id");
        if (StringUtils.isNotBlank(id)) {
            if (id.contains("1")) {
                servletResponse.getWriter().write("id包含1");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
