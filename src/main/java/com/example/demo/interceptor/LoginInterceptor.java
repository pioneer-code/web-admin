package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆检查
 * 1、配置好拦截器要拦截哪些请求
 * 2、把这些配置放在容器中
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆检查逻辑
        HttpSession session = request.getSession();
        Object user = session.getAttribute("loginUser");
        if(user!=null){
            //放行
            return true;
        }
        //拦截
        session.setAttribute("msg","请先登陆");
        response.sendRedirect("/");//重定向
        return false;
    }

    /**
     * 目标方法执行后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 页面渲染后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
