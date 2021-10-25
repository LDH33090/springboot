package com.study;

import com.study.filter.MyHttpSessionListener;
import com.study.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication //声明springboot应用
@ServletComponentScan //该注解的作用是让 springboot 扫描@WebServlet 注解
public class SpringbootWebApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootWebApplication.class, args);

    }

    //把自定义的servlet 注册为springboot容器里面的一个bean，得以映射servlet中的doGet()方法
    @Bean
    public ServletRegistrationBean<MyServlet> getServletRegistrationBean() {
        ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>(new MyServlet());
        bean.setLoadOnStartup(1);
        return bean;
    }

    //把自定义的listener 注册为springboot容器里面的一个bean
    @Bean
    public ServletListenerRegistrationBean listenerRegist() {
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new MyHttpSessionListener());
        System.out.println("listener");
        return srb;
    }
}
