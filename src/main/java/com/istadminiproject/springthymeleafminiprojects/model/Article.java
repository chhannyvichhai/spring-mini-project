package com.istadminiproject.springthymeleafminiprojects.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private int id;
    private String title;
    private String description;
    private String imgURL;
    private Author author;
    private Category[] category;
}
