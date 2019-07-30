package com.ljy.Servlet0004;


import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    String encoding=null;//字符编码
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding=filterConfig.getInitParameter("encoding");
        System.out.println("filter is initialize ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(encoding!=null){
            servletRequest.setCharacterEncoding(encoding);
            servletResponse.setContentType("text/html;charset="+encoding);
        }
        //将其向下传递
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        encoding=null;
        System.out.println("filter is destroy");
    }
}
