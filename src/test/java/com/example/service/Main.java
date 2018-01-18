package com.example.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.entity.Category;
import com.example.entity.Product;

public class Main {
	static CategoryService categoryService;
	static ProductService productService;
	static MediaService mediaService;
	static {
		ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
		categoryService = app.getBean(CategoryService.class);
		productService = app.getBean(ProductService.class);
		mediaService = app.getBean(MediaService.class);
	}

	public static void main(String[] args) {
//		ProductServiceTest t = new ProductServiceTest(productService,categoryService);
//		System.out.println("Test case testFindProductBasedOnID");
//		t.testFindProductBasedOnID();
//		System.out.println("Test case testFindProductBasedOnName");
//		t.testFindProductBasedOnName();
//		System.out.println("Test case testAddProductInACategory");
//		t.testAddProductInACategory();
//		System.out.println("Test case testDeleteProduct");
//		t.testDeleteProduct();
//		t.testChange&ProductCategory();
		MediaServiceTest m = new MediaServiceTest(mediaService,productService);
		m.testUpdateMedia();		System.exit(0);
	}
	

	

}
