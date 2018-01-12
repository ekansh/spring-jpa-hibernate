package com.example.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.config.AppConfig;
import com.example.entity.Image;
import com.example.entity.Media;
import com.example.entity.Product;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class ProductServiceTest extends TestCase
{
	@Autowired
	ProductService productService;
	public ProductServiceTest() {
	}

   @Test
   @Transactional
    public void testInsertMedia(){
//    	Product p = new Product();
//    	p.setName("p1");
//    	Media m_1 = new Image();
//		m_1.setName("Products Image 1");
//		Media m_2 = new Image();
//		m_2.setName("Products Image 2");
//		p.addMedia(m_1);
//		p.addMedia(m_2);
//		productService.add(p);
//		List<Product> products = productService.listProduct();
//		for (Product product : products) {
//			System.out.println("Product Name, ID "+ product.getName()+","+product.getProductid());
//			
//			List<Media> media = product.getMedia();
//			
//			for(Media m1 : media){
//				System.out.println("Media Name and Media id "+ m1.getName()+","+m1.getId());
//				
//			}
//		}
    }
}