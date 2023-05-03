package com.istadminiproject.springthymeleafminiprojects.controller;



//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class ArticleController {
//
//    @GetMapping("/index")
//    String index(){
//        return "articlecard";
//    }
//
//    @GetMapping("/allusers")
//    String users(){
//        return "allusers";
//    }
//
//    @GetMapping("/addnew")
//    String addnew(){
//        return "addnewarticle";
//    }
//}


import com.istadminiproject.springthymeleafminiprojects.service.ArticleService;
import com.istadminiproject.springthymeleafminiprojects.service.AuthorService;
import com.istadminiproject.springthymeleafminiprojects.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AuthorController {
    ArticleService articleService;
    AuthorService authorService;
    CategoryService categoryService;
    AuthorController(ArticleService articleService, AuthorService authorService, CategoryService categoryService) {
        this.articleService = articleService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }
    @GetMapping("/allAuthors")
    public String allUsers(Model model){
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "pages/allAuthors";
    }

    @GetMapping("/author/{id}/{name}")
    public String getAuthorById(@PathVariable int id, @PathVariable String name, Model model){
        model.addAttribute("author", authorService.getAuthorById(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("articles", articleService.getArticlesByAuthorName(name));
        return "pages/authorProfile";
    }
}

