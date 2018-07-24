package com.yanhuan.yhssm.listener;

import javax.servlet.*;

/**
 * ServletRequestListener,Request监听器
 *
 * @author yanhuan1
 */
public class MyRequestListener implements ServletRequestListener, ServletRequestAttributeListener {

    /**
     * 浏览器过来的请求方法执行完成结束时执行
     *
     * @param servletRequestEvent
     */
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        String remoteAddr = servletRequest.getRemoteAddr();
        System.out.println("MyRequestListener requestDestroyed remoteAddr:" + remoteAddr);
    }

    /**
     * 请求过来的时候执行
     *
     * @param servletRequestEvent
     */
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        servletRequest.setAttribute("rule", "6,6,80");
        String remoteAddr = servletRequest.getRemoteAddr();
        System.out.println("MyRequestListener requestInitialized remoteAddr:" + remoteAddr);
    }

    /**
     * 请求request中添加属性时执行
     *
     * @param servletRequestAttributeEvent
     */
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        if (servletRequestAttributeEvent.getName().equals("rule")) {
            System.out.println("MyRequestListener attributeAdded rule:" + servletRequestAttributeEvent.getValue());
        }
    }

    /**
     * 属性移除的时候执行
     *
     * @param servletRequestAttributeEvent
     */
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        if (servletRequestAttributeEvent.getName().equals("rule")) {
            System.out.println("MyRequestListener attributeRemoved rule:" + servletRequestAttributeEvent.getValue());
        }
    }

    /**
     * 属性被替换的时候执行
     *
     * @param servletRequestAttributeEvent
     */
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        if (servletRequestAttributeEvent.getName().equals("rule")) {
            System.out.println("MyRequestListener attributeReplaced rule:" + servletRequestAttributeEvent.getValue());
        }
    }
}
