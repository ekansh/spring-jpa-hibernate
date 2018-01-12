package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.dao.ProductDao;
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
System.out.println("ProductServiceImpl.listProduct() - check if transaction is actually active :"+TransactionSynchronizationManager.isActualTransactionActive());
	   return productDao.listProduct();
   }

}
