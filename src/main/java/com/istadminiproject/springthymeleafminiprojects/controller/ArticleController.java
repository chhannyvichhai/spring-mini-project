package com.istadminiproject.springthymeleafminiprojects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    @GetMapping("/index")
    String index(){
        return "articlecard";
    }

    @GetMapping("/allusers")
    String users(){
        return "allusers";
    }

    @GetMapping("/addnew")
    String addnew(){
        return "addnewarticle";
    }
}
