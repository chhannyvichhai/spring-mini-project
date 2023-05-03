package com.istadminiproject.springthymeleafminiprojects.service;

import com.istadminiproject.springthymeleafminiprojects.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(int id);
}
