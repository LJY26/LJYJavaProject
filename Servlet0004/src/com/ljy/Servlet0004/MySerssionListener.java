package com.ljy.Servlet0004;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySerssionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("servlet session init");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("servlet session destroyed");
    }
}
