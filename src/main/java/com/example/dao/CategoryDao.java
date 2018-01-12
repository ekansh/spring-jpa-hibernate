package com.example.dao;


import java.util.List;

import com.example.entity.Category;

public interface CategoryDao {
	Category find(long categoryid);
	Category find(String name);
	void add(Category thisCategory);
	void delete(long categoryid);
	void update (Category category); 
	public List<Category> findAll();
}
