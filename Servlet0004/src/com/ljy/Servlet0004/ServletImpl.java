package com.ljy.Servlet0004;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletImpl implements Servlet {
    ServletConfig config=null;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config=config;
        System.out.println("servlet is initialized Thread ID"+Thread.currentThread().getId());
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        System.out.println("one request Thread ID"+Thread.currentThread().getId());

        PrintWriter printWriter=servletResponse.getWriter();
        printWriter.print("<html><body>");
        printWriter.print("<div style=\"text-align:center;\"><h2>hello servlet Impl</h2></div>");
        printWriter.print("</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "copyright 2012-2020";
    }

    @Override
    public void destroy() {
        System.out.println("servlet is destroyed Thread ID"+Thread.currentThread().getId());
    }
}
