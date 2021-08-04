package com.example.demo.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyRegistConfig {

    @Bean //讲Servlet组件注册到容器中
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet,"/my","/my02");
    }


    @Bean //拦截器
    public FilterRegistrationBean myFilter(){

        MyFilter myFilter = new MyFilter();
//        return new FilterRegistrationBean(myFilter,myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));//拦截路径
        return filterRegistrationBean;
    }

    @Bean  //监听器
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener mySwervletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(mySwervletContextListener);
    }
}