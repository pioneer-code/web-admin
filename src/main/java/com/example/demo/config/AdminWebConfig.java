package com.example.demo.config;

import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//拦截所有资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");//不拦截的资源
    }
}
