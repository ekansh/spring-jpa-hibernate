package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.config.AppConfig;
import com.example.entity.Category;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class CategoryServiceTestNew extends TestCase {
	@Autowired
	CategoryService categoryService;
	@PersistenceContext
	private EntityManager em;

	public CategoryServiceTestNew() {
	}


	/**
	 * CAT-1
	 */
	@Test
	public void testFindCategoryBasedOnID() {
		Category Phones = categoryService.find(TestCaseConstants.CategoryConstantNew.PHONES_PK);
		assertNotNull(Phones);
		assertEquals(TestCaseConstants.CategoryConstantNew.PHONES, Phones.getName());
		Category root = Phones.getParentCategory();
		assertNotNull(root);
		assertEquals(TestCaseConstants.CategoryConstantNew.root_PK, (long) root.getCategoryid());
		assertEquals("parent category name mismatch", TestCaseConstants.CategoryConstantNew.ROOT, root.getName());
	}

	/**
	 * CAT-2
	 */
	@Test
	public void testFindCategoryBasedOnName() {
		Category root = categoryService.find(TestCaseConstants.CategoryConstantNew.ROOT);
		assertNotNull(root);
		assertEquals(TestCaseConstants.CategoryConstantNew.root_PK, (long) root.getCategoryid());
		Category rootAParent = root.getParentCategory();
		assertNull(rootAParent);
	}

	/**
	 * CAT-4
	 */
	@Test
	public void testAddCategoryUsingParentCategoryId() {
		System.out.println("adding a sub category to " + TestCaseConstants.CategoryConstantNew.PHONES);
		Category nokia = new Category();
		nokia.setName(TestCaseConstants.CategoryConstantNew.NOKIA);
		Category phones = categoryService.find(TestCaseConstants.CategoryConstantNew.PHONES);
		nokia.setParentCategory(phones);
		categoryService.add(nokia);
	}



}