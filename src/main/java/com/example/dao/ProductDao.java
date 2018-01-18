package com.example.dao;

import java.util.List;

import com.example.entity.Product;

public interface ProductDao {
		Product find(long productid);
		Product find(String name);
		void add(Product thisProduct);
		void delete(long productid);
		void update (Product product); 
		public List<Product> findAll();
}
