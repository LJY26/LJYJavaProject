package com.ljy.Servlet0004;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String author=req.getParameter("author");
        String price=req.getParameter("price");
        out.println("<h2>图书信息添加成功</h2>");
        out.println("图书编号:"+id+"<br/>");
        out.println("图书名称："+name+"<br/>");
        out.println("作者："+author+"<br/>");
        out.println("价格："+price+"<br/>");
        out.flush();
        out.close();
    }
}
