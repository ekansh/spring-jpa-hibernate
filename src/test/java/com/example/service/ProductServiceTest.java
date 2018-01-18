package com.example.service;

import java.util.List;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.config.AppConfig;
import com.example.entity.Product;
import com.example.entity.Video;
import com.example.entity.Category;
import com.example.entity.Image;
import com.example.entity.Media;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class ProductServiceTest extends TestCase {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	MediaService mediaService;

	public ProductServiceTest() {
	}
	public ProductServiceTest(ProductService productService,CategoryService categoryService) {
		this.productService=productService;
		this.categoryService=categoryService;
	}
	/**
	 * PRD-1
	 */
	public void testFindProductBasedOnID() {
		Product s6 = productService.find(TestCaseConstants.ProductConstant.S6_PK);
		assertNotNull(s6);
		assertEquals(TestCaseConstants.ProductConstant.S6, s6.getName());
		Category samsung = s6.getCategory();
		assertNotNull(samsung);
		assertEquals(TestCaseConstants.CategoryConstantNew.SAMSUNG_PK, (long) samsung.getCategoryid());
	}

	/**
	 * PRD-2
	 */
	public void testFindProductBasedOnName() {
		Product s6 = productService.find(TestCaseConstants.ProductConstant.S6);
		assertNotNull(s6);
		assertEquals(TestCaseConstants.ProductConstant.S6, s6.getName());
		Category samsung = s6.getCategory();
		assertNotNull(samsung);
		assertEquals(TestCaseConstants.CategoryConstantNew.SAMSUNG_PK, (long) samsung.getCategoryid());
	}

	/**
	 * PRD-4
	 */
//	@Test
	public void testAddProductInACategory() {
		Product s11 = new Product();
		Media mainImage = new Image();
		mainImage.setName(TestCaseConstants.MediaConstant.S11_MAIN_IMAGE);
		Media thumbnail = new Video();

		thumbnail.setName(TestCaseConstants.MediaConstant.S11_THUMBNAIL_VIDEO);
		s11.addMedia(mainImage);
		s11.addMedia(thumbnail);
		s11.setName(TestCaseConstants.ProductConstant.S11);
		Category samsung = categoryService.find(TestCaseConstants.CategoryConstantNew.SAMSUNG_PK);
		//TODO If the category gets deleted service should throw an exception
		productService.addProductInACategory(s11, samsung);
		Product s11_ = productService.find(TestCaseConstants.ProductConstant.S11);
		assertNotNull(s11_);
		assertEquals(TestCaseConstants.ProductConstant.S11, s11_.getName());
		Category samsung_ = s11_.getCategory();
		assertNotNull(samsung_);
		assertEquals(TestCaseConstants.CategoryConstantNew.SAMSUNG_PK, (long) samsung_.getCategoryid());
		List<Media> media = s11_.getMedia();
		boolean anyMatch = media.stream().anyMatch(e-> TestCaseConstants.MediaConstant.S11_THUMBNAIL_VIDEO.equals(e.getName()));
		assertTrue(anyMatch);
		boolean anyMatch_ = media.stream().anyMatch(e-> TestCaseConstants.MediaConstant.S11_MAIN_IMAGE.equals(e.getName()));
		assertTrue(anyMatch_);
		
	}
//
//	/**
//	 * PRD-5
//	 */
//	@Test
//	@Rollback(false)
	public void testDeleteProduct() {
		Product z3 = productService.find(TestCaseConstants.ProductConstant.Z3);
		assertNotNull(z3);
		System.out.println("Product available hence deleting it");
		productService.delete(TestCaseConstants.ProductConstant.Z3_PK);
		System.out.println("-------");
		Product _z3 = productService.find(TestCaseConstants.ProductConstant.Z3);
		assertNull(_z3);
		Category bb = categoryService.find(TestCaseConstants.CategoryConstantNew.BLACKBERRY_PK);
		assertNotNull(bb);
		Media mainImage = mediaService.find(TestCaseConstants.MediaConstant.Z3_MAIN_IMAGE);
		Media thumbnail = mediaService.find(TestCaseConstants.MediaConstant.Z3_THUMBNAIL_VIDEO);
		assertNull(mainImage);
		assertNull(thumbnail);
	}
//	/**
//	 * PRD-6 Updating the name of a category and making sure the children still
//	 * exist
//	 */
//	@Test
	public void testChangeProductCategory() {
		
		Product g6 = productService.find(TestCaseConstants.ProductConstant.G6_PK);
		assertNotNull(g6);
		Category s= categoryService.find(TestCaseConstants.CategoryConstantNew.SAMSUNG);
		assertNotNull(s);
		g6.setCategory(s);
		productService.update(g6);
//		boolean anyMatch = samsung.getProducts().stream().anyMatch(e -> TestCaseConstants.ProductConstant.S3.equals(s3.getName()) );
//		assertFalse(anyMatch);
//		Product _s3 = productService.find(TestCaseConstants.ProductConstant.S3);
//		assertNotNull(_s3);
//		Category _lg = _s3.getCategory();
//		assertNotNull(_lg);
//		boolean anyMatchLG = _lg.getProducts().stream().anyMatch(e -> TestCaseConstants.ProductConstant.S3.equals(s3.getName()) );
//		assertFalse(anyMatchLG);
//		
//		List<Media> media = _s3.getMedia();
//		boolean anyMatch1 = media.stream().anyMatch(e-> TestCaseConstants.MediaConstant.S3_THUMBNAIL_VIDEO.equals(e.getName()));
//		assertTrue(anyMatch1);
//		boolean anyMatch2 = media.stream().anyMatch(e-> TestCaseConstants.MediaConstant.S3_MAIN_IMAGE.equals(e.getName()));
//		assertTrue(anyMatch2);
		
	}
//
//	/**
//	 * PRD-7
//	 *
//	 */
	@Test
	// @Transactional
	// @Rollback(false)
	public void testUpdateProduct() {
		Product g6 = productService.find(TestCaseConstants.ProductConstant.G6);
		assertNotNull(g6);
		g6.setName(TestCaseConstants.ProductConstant.G6+"_up");
		productService.update(g6);
		
		Product _g6 = productService.find(TestCaseConstants.ProductConstant.G6);
		assertNotNull(_g6);
		assertEquals(TestCaseConstants.ProductConstant.G6+"_up", _g6.getName());
		
	}
//	@Test
	public void testGetAllImagesOfAProduct() {
		Product s6 = productService.find(TestCaseConstants.ProductConstant.S6);
		assertNotNull(s6);
		assertEquals(TestCaseConstants.ProductConstant.S6, s6.getName());

		long count = s6.getMedia().stream()
				.filter(e -> (TestCaseConstants.MediaConstant.S6_MAIN_IMAGE.equals(e.getName())
						|| TestCaseConstants.MediaConstant.S6_THUMBNAIL_VIDEO.equals(e.getName())
						))
				.distinct().count();
		assertEquals(2, count);
	}

	
}