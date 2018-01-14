package com.example.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;

public class Main {
	public static void main(String[] args) {
		ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
		CategoryService categoryService = app.getBean(CategoryService.class);
//		CategoryServiceTest test= new CategoryServiceTest(categoryService);
		categoryService.delete(9131L);
//		test.testFindCategoryBasedOnID();
//		test.testFindCategoryBasedOnName();
//		test.testAddCategoryUsingParentCategoryId();
//		test.testUpdateCategory();
//		test.testChangeCategory();
//		test.testDeleteCategory();
	}
	
}
