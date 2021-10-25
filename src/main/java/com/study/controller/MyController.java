package com.study.controller;


import com.study.filter.MyHttpSessionListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*@RestController*/
@Controller
public class MyController {

    @RequestMapping("/hello")
    public String hello(HttpSession session){
        session.setAttribute("one","aaaaa");
        return "hello spring-boot";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.setAttribute("aa","one");
        System.out.println("进入登录");
        return "login";
    }

    @RequestMapping("/online")
    @ResponseBody
    public String online(){
        System.out.println("我是大熊");
        return "当前在线人数："+MyHttpSessionListener.online +"人";
    }

}
