package com.ljy.Servlet0004;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Optional;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");// ;charset=utf-8 使用过滤器实现中文处理

        PrintWriter printWriter=resp.getWriter();

        ServletConfig config=getServletConfig();
//        String helloMessage=config.getInitParameter("helloMessage");
//        printWriter.print(helloMessage);
//        Enumeration<String> e=config.getInitParameterNames();
//        while (e.hasMoreElements()) {
//            printWriter.print(config.getInitParameter(e.nextElement()) + "\n");
//        }
//
//        printWriter.print("servletConfig 获取ContextParam：\n");
//        ServletContext servletContext=config.getServletContext();
//        Enumeration<String> contextInitParm=servletContext.getInitParameterNames();
//        while (contextInitParm.hasMoreElements()){
//            printWriter.print(servletContext.getInitParameter(contextInitParm.nextElement())+"\n");
//        }
//
//        printWriter.print("generservlet 获取ContextParam：\n");
//        ServletContext servletContext2=getServletContext();
//        contextInitParm=servletContext2.getInitParameterNames();
//        while (contextInitParm.hasMoreElements()){
//            printWriter.print(servletContext2.getInitParameter(contextInitParm.nextElement())+"\n");
//        }


        Cookie[] cookies=req.getCookies();
        if(cookies!=null&&cookies.length>0) {
            Optional<Cookie> cookieOptional =Arrays.asList(cookies).stream().filter(t->t.getName().equals("name")).findFirst();
            if(cookieOptional!=null&&cookieOptional.isPresent()) {
                printWriter.print("会员：" + cookieOptional.get().getValue());
            }
        }

//        servletContext.setAttribute("Message","Hello");
//        servletContext2.setAttribute("Message","您好，");
//        printWriter.print(servletContext.equals(servletContext2)?"true":"false");
        req.getRequestDispatcher("/index.jsp").include(req,resp);

    }
}
