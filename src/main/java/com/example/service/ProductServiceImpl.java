package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.dao.ProductDao;
import com.example.entity.Category;
import com.example.entity.Product;

/**
 * @author ekansh
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional
	@Override
	public void add(Product product) {
		productDao.add(product);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Product> listProduct() {
		System.out.println("ProductServiceImpl.listProduct() - check if transaction is actually active :"
				+ TransactionSynchronizationManager.isActualTransactionActive());
		return productDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Product find(Long productid) {
		Product find = productDao.find(productid);
		return find;
	}

	@Transactional
	@Override
	public Product find(String name) {
		Product find = productDao.find(name);
		return find;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	@Transactional
	@Override
	public void delete(Long productid) {
		productDao.delete(productid);
	}
	@Transactional
	@Override
	public void addProductInACategory(Product product, Category category) {
		product.setCategory(category);
		productDao.add(product);
	}

}
