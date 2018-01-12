package com.example.service;

import java.util.List;

import com.example.entity.Category;


public interface CategoryService {
    public void add(Category category);
    public Category find(Long categoryid);

    public Category find(String name);
    
    public void update(Category category);
    public void delete(Long categoryid);
    
    public List<Category> listCategory();
}
