package com.yanhuan.yhssm.interceptors;

import com.yanhuan.yhssm.dao.UrlInvokeDao;
import com.yanhuan.yhssm.domain.pojo.UrlInvoke;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * url拦截器，用于保存url调用的记录
 */
public class UrlInvokeInterceptor implements HandlerInterceptor {

    @Resource
    private UrlInvokeDao urlInvokeDao;

    private Long curTimeMillSecond;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        this.curTimeMillSecond = System.currentTimeMillis();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        UrlInvoke urlInvoke = new UrlInvoke();
        //获取请求的URL
        String url = httpServletRequest.getRequestURI();
        //获取Session
        HttpSession session = httpServletRequest.getSession();
        String username = (String) session.getAttribute("username");
        urlInvoke.setUrl(url);
        urlInvoke.setUsername(username);
        urlInvoke.setInvokeTime(new Date(getCurTimeMillSecond()));
        urlInvoke.setInvokeDuration(System.currentTimeMillis() - getCurTimeMillSecond());
        urlInvoke.setIsException(e != null ? (byte) 0 : (byte) 1);
        urlInvoke.setCreateUser("system");
        urlInvokeDao.insert(urlInvoke);
    }

    public Long getCurTimeMillSecond() {
        return curTimeMillSecond;
    }

    public void setCurTimeMillSecond(Long curTimeMillSecond) {
        this.curTimeMillSecond = curTimeMillSecond;
    }
}
