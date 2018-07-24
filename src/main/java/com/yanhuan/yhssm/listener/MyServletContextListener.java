package com.yanhuan.yhssm.listener;

import javax.servlet.*;

/**
 * ServletContextListener实现，监听器
 */
public class MyServletContextListener implements ServletContextListener, ServletContextAttributeListener {

    private ServletContext servletContext;

    /**
     * 整个容器初始化的时候进行的一些操作
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("webName", "yhssm");
        System.out.println("MyServletContextListener contextInitialized servletContext:" + servletContext);
    }

    /**
     * 监听器销毁的方法
     *
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute("webName");
        System.out.println("MyServletContextListener contextInitialized contextDestroyed:" + servletContext);
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        if ("webName".equals(servletContextAttributeEvent.getName())) {
            Object value = servletContextAttributeEvent.getValue();
            System.out.println("MyServletContextListener attributeAdded webName:" + value);
        }
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        if ("webName".equals(servletContextAttributeEvent.getName())) {
            Object value = servletContextAttributeEvent.getValue();
            System.out.println("MyServletContextListener attributeRemoved webName:" + value);
        }
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        if ("webName".equals(servletContextAttributeEvent.getName())) {
            Object value = servletContextAttributeEvent.getValue();
            System.out.println("MyServletContextListener attributeReplaced webName:" + value);
        }
    }
}
