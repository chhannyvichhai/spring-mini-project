package com.istadminiproject.springthymeleafminiprojects.repository;



import com.istadminiproject.springthymeleafminiprojects.model.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    List<Author> authors = new ArrayList<>(){{
        add(new Author(1, "KOKo", "jim_12", "Female", "Living my best couch potato life.", "https://i.pinimg.com/564x/0e/1f/25/0e1f2535e47d4958cf0c409802f3ddcf.jpg","https://i.pinimg.com/564x/a2/49/2e/a2492e1cff4aaf71028dad958f2a8382.jpg", "koko@gmail.com", " #5A, St.598 S/K Ruessei keav, Khan Russei Kaev"));
        add(new Author(2, "Jin","jasmine_jas", "Female", "Sometime i wish i were a cat, just meow.", "https://i.pinimg.com/474x/bb/49/c4/bb49c401bbea76476275584508506105.jpg", "https://i.pinimg.com/564x/33/6c/09/336c0969011a09b11b8e12ae8f48a28b.jpg", "jin12@gmail.com", "St.1986 S/K Phnom penh thmey, Khan Sean Sok"));
        add(new Author(3, "King King", "jess_blue", "Female", "Stay kind because why not?", "https://i.pinimg.com/564x/09/fe/3d/09fe3d00851c06d3e6cf51bd6bc3e661.jpg", "https://i.pinimg.com/564x/d9/54/b6/d954b69f2da49f832c59707526c0c2a5.jpg", "kingking@gmail.com", " #150, St.488 S/K Phsar Daeum Thkov, Khan Chamkar Mon"));
        add(new Author(4, "Cat Cat", "senku_king_science", "Male", "The world is nothing without science", "https://i.pinimg.com/564x/bc/68/09/bc6809f6255320474a4f969d0839460f.jpg","https://i.pinimg.com/564x/24/f2/bb/24f2bbc6bd6d601ef695cad1e448bc0e.jpg", "catme@gmail.com", " #5A, St.598 S/K Ruessei keav, Khan Russei Kaev"));
    }};
    public List<Author> getAuthors(){
        return authors;
    }

    public Author getAuthorById(int id){
        return authors.stream().filter(e-> e.getId() == id).findFirst().orElse(null);
    }
}