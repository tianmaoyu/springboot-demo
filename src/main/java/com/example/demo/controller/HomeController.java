package com.example.demo.controller;

import com.example.demo.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home/")
public class HomeController {


    @Autowired
    private  UserConfig user;
/*

d
 */
@Cacheable
    @RequestMapping("index")
    public  String index(ModelMap modelMap){
        modelMap.addAttribute("user",user);
        return "index" ;
    }

    @RequestMapping("home")
    public  String home(){
        return "home" ;
    }
}
