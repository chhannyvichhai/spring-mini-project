package com.istadminiproject.springthymeleafminiprojects.service.serviceImpl;


import com.istadminiproject.springthymeleafminiprojects.model.Category;
import com.istadminiproject.springthymeleafminiprojects.repository.CategoryRepository;
import com.istadminiproject.springthymeleafminiprojects.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    CategoryServiceImpl(){
        categoryRepository = new CategoryRepository();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getCategories();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.getCategoryById(id);
    }
}
