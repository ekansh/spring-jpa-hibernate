package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.dao.CategoryDao;
import com.example.dao.ProductDao;
import com.example.entity.Category;
import com.example.entity.Product;

/**
 * @author ekansh
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	 @Transactional
	public void add(Category category) {
		categoryDao.add(category);
	}
	 @Transactional(readOnly = true)
	@Override
	public Category find(Long categoryid) {
		Category find = categoryDao.find(categoryid);
		return find;
	}
	 @Transactional(readOnly = true)
	@Override
	public Category find(String name) {
		Category find = categoryDao.find(name);
		return find;
	}
	 @Transactional
	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}
	 @Transactional
	@Override
	public void delete(Long categoryid) {
		categoryDao.delete(categoryid);
	}
	 @Transactional
	@Override
	public List<Category> listCategory() {
		return categoryDao.findAll();
	}

}
