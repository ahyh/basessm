package com.yanhuan.yhssm.listener;

import javax.servlet.http.*;

/**
 * SessionListener:Session监听器
 *
 * @author yanhuan1
 */
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setAttribute("username", "yanhuan");
        System.out.println("MySessionListener sessionCreated!");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.removeAttribute("username");
        System.out.println("MySessionListener sessionCreated!");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        if ("username".equals(httpSessionBindingEvent.getName())) {
            Object value = httpSessionBindingEvent.getValue();
            System.out.println("MySessionListener attributedAdded username:" + value);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        if ("username".equals(httpSessionBindingEvent.getName())) {
            Object value = httpSessionBindingEvent.getValue();
            System.out.println("MySessionListener attributeRemoved username:" + value);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        if ("username".equals(httpSessionBindingEvent.getName())) {
            Object value = httpSessionBindingEvent.getValue();
            System.out.println("MySessionListener attributeReplaced username:" + value);
        }
    }
}
