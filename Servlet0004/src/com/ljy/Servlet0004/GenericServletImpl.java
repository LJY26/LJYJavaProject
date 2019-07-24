package com.ljy.Servlet0004;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GenericServletImpl extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        System.out.println("one request Thread ID"+Thread.currentThread().getId());

        PrintWriter printWriter=servletResponse.getWriter();
        printWriter.print("<html><body>");
        printWriter.print("<div style=\"text-align:center;\"><h2>hello genericServlet Impl</h2></div>");
        printWriter.print("</body></html>");
    }
}
