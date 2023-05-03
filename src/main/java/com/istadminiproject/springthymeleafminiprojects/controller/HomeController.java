package com.istadminiproject.springthymeleafminiprojects.controller;


import com.istadminiproject.springthymeleafminiprojects.model.Article;
import com.istadminiproject.springthymeleafminiprojects.service.ArticleService;
import com.istadminiproject.springthymeleafminiprojects.service.AuthorService;
import com.istadminiproject.springthymeleafminiprojects.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    ArticleService articleService;
    AuthorService authorService;
//    FileUploadService  fileUploadService;
    CategoryService categoryService;
    HomeController(ArticleService articleService, AuthorService authorService, CategoryService categoryService) {
        this.articleService = articleService;
        this.authorService = authorService;
        this.categoryService = categoryService;

    }
    @GetMapping("/")
    public String getAllArticles(Model model){
        model.addAttribute("articles", articleService.getArticles().stream().sorted(((o1, o2) -> o2.getId()-o1.getId())));
        model.addAttribute("categories" , categoryService.getAllCategories());
        return  "articlecard";
    }
    @GetMapping("/article/{articleID}")
    public String getArticleByID(@PathVariable int articleID, Model model){
        model.addAttribute("articles", articleService.getArticleById(articleID));
        return "pages/articleDetail";
    }

    @GetMapping("/allusers")
    String allusers(){
        return "allusers";
    }
//    @GetMapping("/add-new-article")
//    public String addNewArticle(Model model){
//        model.addAttribute("articles", new ArticleRequest());
//        model.addAttribute("authors", authorService.getAllAuthors());
//        model.addAttribute("categories", categoryService.getAllCategories());
//        return "/pages/addArticle";
//    }

//    @PostMapping("/handle-add-article")
//    public  String handleAddArticle(@ModelAttribute("articles") @Valid ArticleRequest article, BindingResult bindingResult, Model model) {
//        if(bindingResult.hasErrors()){
//            model.addAttribute("authors", authorService.getAllAuthors());
//            model.addAttribute("categories", categoryService.getAllCategories());
//            return "/pages/addArticle";
//        }
//        Article newArticle = new Article();
//        try{
//            String filenames ="http://localhost:8080/images/"+ fileUploadService.uploadFile(article.getFile());
//            System.out.println("Filename is "+filenames);
//            newArticle.setImgURL(filenames);
//        } catch (Exception ex){
//            newArticle.setImgURL("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Placeholder_view_vector.svg/681px-Placeholder_view_vector.svg.png");
//            System.out.println("Error : "+ex.getMessage());
//        }
//        newArticle.setTitle(article.getTitle());
//        newArticle.setDescription(article.getDescription());
//        newArticle.setAuthor(authorService.getAllAuthors().stream().filter(e->e.getId()==article.getAuthorId()).findFirst().orElse(null));
//        // Create an array of Category objects from the categoryIds in the ArticleRequest object
//        List<Category> categories = new ArrayList<>();
//        for(int categoryId: article.getCategoryId()){
//            categories.add(categoryService.getAllCategories().stream().filter(e -> e.getCategoryId() == categoryId).findFirst().orElse(null));
//        }
//        Category[] categoryArray = categories.toArray(new Category[categories.size()]);
//        newArticle.setCategory(categoryArray);
//        // Get the maximum ID from the existing articles and increment it by 1 to set as the ID of the new article
//        newArticle.setId(articleService.getArticles().stream().max(Comparator.comparingInt(Article::getId)).stream().toList().get(0).getId()+1);
//
//        articleService.addNewArticle(newArticle);
//        return "redirect:/";
//    }

    @GetMapping("/delete-article/{id}")
    public String deleteArticle(@PathVariable int id, @RequestParam String source, Model model){
        articleService.deleteArticle(id);
        // Should I add these 3 lines code below??
        model.addAttribute("articles", articleService.getArticles());
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "redirect:/";
    }


    @GetMapping("/category/{categoryID}")
    public String getArticleByCategoryId(@PathVariable int categoryID, Model model){
        model.addAttribute("articles", articleService.getArticleByCategoryId(categoryID));
        model.addAttribute("category", categoryService.getCategoryById(categoryID));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "pages/category";
    }
}
