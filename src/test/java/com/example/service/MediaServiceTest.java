package com.example.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.config.AppConfig;
import com.example.entity.Category;
import com.example.entity.Image;
import com.example.entity.Media;
import com.example.entity.Product;
import com.example.entity.Media;
import com.example.entity.Video;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class MediaServiceTest extends TestCase
{
	@Autowired
	ProductService productService;
	@Autowired
	MediaService mediaService;
	public MediaServiceTest() {
	}
	public MediaServiceTest(MediaService mediaService2,ProductService productService) {
		this.mediaService=mediaService2;
		this.productService=productService;
	}
	@Test
	public void testFindMediaBasedOnID() {
		Media s6 = mediaService.find(TestCaseConstants.MediaConstant.S6_MAIN_IMAGE);
		assertNotNull(s6);
		assertEquals(TestCaseConstants.MediaConstant.S6_MAIN_IMAGE, s6.getName());
		Product samsungS6 = s6.getProduct();
		assertNotNull(samsungS6);
		assertEquals((long)TestCaseConstants.ProductConstant.S6_PK, (long) samsungS6.getProductid());
	}


	/**
	 * MED-5
	 */
	@Test
	@Rollback(false)
	public void testDeleteMedia() {
		Media image1 = mediaService.find(TestCaseConstants.MediaConstant.LUMIA_MAIN_IMAGE);
		assertNotNull(image1);
		mediaService.delete(TestCaseConstants.MediaConstant.LUMIA_MAIN_IMAGE_PK);
		Media image1_ = mediaService.find(TestCaseConstants.MediaConstant.LUMIA_MAIN_IMAGE_PK);
		assertNull(image1_);
		Product lumia = productService.find(TestCaseConstants.ProductConstant.LUMIA);
		assertNotNull(lumia);
	}


	/**
	 * MED-7
	 *
	 */
	@Test
	// @Transactional
	// @Rollback(false)
	public void testUpdateMedia() {
		Media iP1 = mediaService.find(TestCaseConstants.MediaConstant.LUMIA_THUMBNAIL_VIDEO);
		assertNotNull(iP1);
		iP1.setName(TestCaseConstants.MediaConstant.LUMIA_THUMBNAIL_VIDEO+"_up");
		mediaService.update(iP1);
		System.out.println("Updated..");
		Media _ip1 = mediaService.find(TestCaseConstants.MediaConstant.LUMIA_THUMBNAIL_VIDEO_PK);
		assertNotNull(_ip1);
		assertEquals(TestCaseConstants.MediaConstant.LUMIA_THUMBNAIL_VIDEO+"_up", _ip1.getName());
		
	}
}