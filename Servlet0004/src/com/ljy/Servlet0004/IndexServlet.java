package com.ljy.Servlet0004;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter printWriter=resp.getWriter();

        ServletConfig config=getServletConfig();
//        String helloMessage=config.getInitParameter("helloMessage");
//        printWriter.print(helloMessage);
        Enumeration<String> e=config.getInitParameterNames();
        while (e.hasMoreElements()){
            printWriter.print(config.getInitParameter(e.nextElement())+"\n");
        }

        req.getRequestDispatcher("/index.jsp").include(req,resp);

    }
}
