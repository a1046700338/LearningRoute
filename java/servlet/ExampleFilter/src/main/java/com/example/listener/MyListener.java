package com.example.listener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class MyListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    Integer count = 0;
    private ServletContext context = null;
    public MyListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.println("容器创建");
        sce.getServletContext().setAttribute("countMsg",0);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("容器销毁");

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        HttpSession session = se.getSession();
        System.out.println("用户"+session.getId()+"上线了");
        Integer count = (Integer) session.getServletContext().getAttribute("countMsg");
        count++;
        session.getServletContext().setAttribute("countMsg", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        HttpSession session = se.getSession();
        System.out.println(session.getId()+"离线了。。。");
        Integer count = (Integer) session.getServletContext().getAttribute("countMsg");
        count--;
        session.getServletContext().setAttribute("countMsg", count);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
        System.out.println("attribute已创建");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
        System.out.println("attribute已销毁");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
