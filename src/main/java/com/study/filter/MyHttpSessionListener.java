package com.study.filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 *  自定义监听器实现HttpSessionListener接口
 *  重写创建session方法
 *  重写销毁session方法
 */

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    public static int online = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建session....");
        //表示在创建session对象后 online才会++
        online++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁session.....");
    }
}
