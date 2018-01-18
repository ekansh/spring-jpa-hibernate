package com.example.service;

import java.util.List;

import com.example.entity.Category;
import com.example.entity.Product;

public interface ProductService {
	public void add(Product product);

	public Product find(Long productid);

	public Product find(String name);

	public void update(Product product);

	public void delete(Long productid);

	public List<Product> listProduct();

	public void addProductInACategory(Product s11, Category category);
}
