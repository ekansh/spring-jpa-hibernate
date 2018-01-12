package com.example.service;

import java.util.List;

import com.example.entity.Product;


public interface ProductService {
    void add(Product media);
    List<Product> listProduct();
}
