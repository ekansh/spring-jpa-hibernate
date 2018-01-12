package com.example.dao;

import java.util.List;

import com.example.entity.Media;
import com.example.entity.Product;

public interface ProductDao {
   void add(Product media);
   List<Product> listProduct();
}
