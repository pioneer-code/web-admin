package com.example.demo.controller;

import com.example.demo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @GetMapping(value = {"/basic_table","/basic_table.html"})
    public String basic_table(){

        return "table/basic_table";
    }

    @GetMapping(value = {"/dynamic_table","/dynamic_table.html"})
    public String dynamic_table(Model model){
        List<User> users = Arrays.asList(new User("zhangsan", "122343"),
                new User("lisi", "122343"),
                new User("hha", "122343"),
                new User("hhe", "122343"));
        model.addAttribute("users",users);
        return "table/dynamic_table";
    }

    @GetMapping(value = {"/responsive_table","/responsive_table.html"})
    public String responsive_table(){

        return "table/responsive_table";
    }

    @GetMapping(value = {"/editable_table","/editable_table.html"})
    public String editable_table(){

        return "table/editable_table";
    }
}
