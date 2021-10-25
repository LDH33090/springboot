package com.study.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;



/**
 * 过滤器
 * 1.初始化方法
 * 2.开始过滤方法
 * 3.销毁方法
 */

@WebFilter(filterName = "MyFilter", urlPatterns = "/filter")
public class MyFilter implements Filter {


    //初始化方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init....");
    }

    //过滤器方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    //销毁过滤器方法
    @Override
    public void destroy() {
        System.out.println("destory.......");
    }
}
