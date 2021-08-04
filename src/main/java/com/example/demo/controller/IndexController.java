package com.example.demo.controller;

import com.example.demo.CustomerService;
import com.example.demo.bean.Customer;
import com.example.demo.bean.User;
import com.example.demo.mapper.CustomerMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/sql")
    @ResponseBody
    public String contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from test1", Long.class);
        System.out.println(aLong);
        return aLong.toString();
    }

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String main1(User user, HttpSession session, Model model){
        user.setUserName("lhd");
        user.setPassword("123456");
        if(StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        //是否登陆。拦截器，过滤器
        Object user = session.getAttribute("loginUser");
        if(user!=null){
            return "main";
        }else {
            model.addAttribute("msg","请重新登陆");
            return "login";
        }
    }

    @Autowired
    CustomerService customerService;
    @ResponseBody
    @GetMapping("/getById")
    public Customer getById(@RequestParam("id") Integer id){
        Customer cus = customerService.getById(id);
        return cus;
    }

    @Autowired
    CustomerMapper customerMapper ;
    @ResponseBody
    @GetMapping("/getById1")
    public Customer getById1(@RequestParam("id") Integer id){
        Customer cus = customerMapper.getCus(id);
        return cus;
    }

}
