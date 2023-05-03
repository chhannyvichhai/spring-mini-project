package com.istadminiproject.springthymeleafminiprojects.service.serviceImpl;



import com.istadminiproject.springthymeleafminiprojects.model.Author;
import com.istadminiproject.springthymeleafminiprojects.repository.AuthorRepository;
import com.istadminiproject.springthymeleafminiprojects.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    AuthorServiceImpl() {
        authorRepository = new AuthorRepository();
    }
    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.getAuthors();
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepository.getAuthorById(id);
    }
}
