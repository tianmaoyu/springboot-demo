package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home/")
public class HomeController {



    @RequestMapping("index")
    public  String index(){
        return "index" ;
    }

    @RequestMapping("home")
    public  String home(){
        return "home" ;
    }
}
