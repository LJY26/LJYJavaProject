package com.ljy.Servlet0004;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servlet has context init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servlet has context Destroyed");
    }
}
