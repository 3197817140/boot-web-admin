package com.eternity.admin.controller;

import com.eternity.admin.bean.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {


    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
//        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//                new User("lisi", "123456"),
//                new User("wangwu", "123456"),
//                new User("zhaoliu", "123456"));
//        model.addAttribute("users",users);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }


    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

}
