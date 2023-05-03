package com.istadminiproject.springthymeleafminiprojects.service;

import com.istadminiproject.springthymeleafminiprojects.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author getAuthorById(int id);
}
