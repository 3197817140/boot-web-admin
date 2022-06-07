package com.eternity.admin.controller;

import com.eternity.admin.bean.City;
import com.eternity.admin.bean.User;
import com.eternity.admin.service.CityService;
import com.eternity.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class IndexController {


    HashMap

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;

    @Autowired
    CityService cityService;


    @GetMapping("/test")
    public String test(){
        return "test";
    }


    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }


    @ResponseBody
    @GetMapping("/selectCity")
    public City getCity(@RequestParam("id") Long id){
        return cityService.getCity(id);
    }


    @ResponseBody
    @GetMapping("/selectById")
    public User getUser(@RequestParam("id") Integer id){
        return userService.getUserById(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFormDb(){
        Integer integer = jdbcTemplate.queryForObject("select count(*) from t_user", Integer.class);
        return integer.toString();
    }



    @GetMapping(value = {"/","/lgoin"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
    }
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null){
            return "main";
        }
        else{
            model.addAttribute("msg","当前未登录");
            return "login";
        }
    }
}
