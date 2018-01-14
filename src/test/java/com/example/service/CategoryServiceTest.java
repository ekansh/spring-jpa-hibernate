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
public class CategoryServiceTest extends TestCase {
	@Autowired
	CategoryService categoryService;
	@PersistenceContext
	private EntityManager em;

	public CategoryServiceTest() {
	}

//	@Before
//	public void setUp() {
//		System.out.println("Initializing the database");
//		Category rootA = new Category();
//		rootA.setName(TestCaseConstants.CategoryConstant.rootA);
////		rootA.setCategoryid(TestCaseConstants.CategoryConstant.rootAPK);
//
//		Category rootAChild1 = new Category();
//		rootAChild1.setName(TestCaseConstants.CategoryConstant.rootAChild1);
////		rootAChild1.setCategoryid(TestCaseConstants.CategoryConstant.rootAChild1PK);
//
//		Category rootAChild2 = new Category();
////		rootAChild2.setCategoryid(TestCaseConstants.CategoryConstant.rootAChild2PK);
//		rootAChild2.setName(TestCaseConstants.CategoryConstant.rootAChild2);
//
//		Category rootAChild3 = new Category();
////		rootAChild3.setCategoryid(TestCaseConstants.CategoryConstant.rootAChild3PK);
//		rootAChild3.setName(TestCaseConstants.CategoryConstant.rootAChild3);
//
//		Category rootAChild1_Child1 = new Category();
//		rootAChild1_Child1.setName(TestCaseConstants.CategoryConstant.rootAChild1_Child1);
////		rootAChild1_Child1.setCategoryid(TestCaseConstants.CategoryConstant.rootAChild1_Child1PK);
//
//		Category rootAChild2_Child1 = new Category();
//		rootAChild2_Child1.setName(TestCaseConstants.CategoryConstant.rootAChild2_Child1);
////		rootAChild2_Child1.setCategoryid(TestCaseConstants.CategoryConstant.rootAChild2_Child1PK);
//
//		Category rootAChild3_Child1 = new Category();
//		rootAChild3_Child1.setName(TestCaseConstants.CategoryConstant.rootAChild3_Child1);
////		rootAChild3_Child1.setCategoryid(TestCaseConstants.CategoryConstant.rootAChild3_Child1PK);
//
//		rootA.addCategories(rootAChild1);
//		rootA.addCategories(rootAChild2);
//		rootA.addCategories(rootAChild3);
//		rootAChild1.addCategories(rootAChild1_Child1);
//		rootAChild2.addCategories(rootAChild2_Child1);
//		rootAChild3.addCategories(rootAChild3_Child1);
//		em.persist(rootA);
//		System.out.println("Database ready for test");
//	}

//	@After
//	public void tearDown() {
//		System.out.println("Clearing DB of test data.. ");
//		Category rootA = categoryService.find(TestCaseConstants.CategoryConstant.rootA);
//		categoryService.delete(rootA.getCategoryid());
//		System.out.println("database cleared of test data belonging to Category entity");
//	}

	/**
	 * CAT-1
	 */
	@Test
	public void testFindCategoryBasedOnID() {
		Category rootAChild1 = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild1PK);
		assertNotNull(rootAChild1);
		assertEquals(TestCaseConstants.CategoryConstant.rootAChild1, rootAChild1.getName());
		Category rootA = rootAChild1.getParentCategory();
		assertNotNull(rootA);
		assertEquals(TestCaseConstants.CategoryConstant.rootAPK, (long) rootA.getCategoryid());
		assertEquals("parent category name mismatch", TestCaseConstants.CategoryConstant.rootA, rootA.getName());
	}

	/**
	 * CAT-2
	 */
	@Test
	public void testFindCategoryBasedOnName() {
		Category rootA = categoryService.find(TestCaseConstants.CategoryConstant.rootA);
		assertNotNull(rootA);
		assertEquals(TestCaseConstants.CategoryConstant.rootAPK, (long) rootA.getCategoryid());
		Category rootAParent = rootA.getParentCategory();
		assertNull(rootAParent);
	}

	/**
	 * CAT-4
	 */
	@Test
	public void testAddCategoryUsingParentCategoryId() {
		System.out.println("adding a sub category to " + TestCaseConstants.CategoryConstant.rootAChild2);
		Category rootAChild2_Child2 = new Category();
		rootAChild2_Child2.setName(TestCaseConstants.CategoryConstant.rootAChild2_Child2);
		Category rootAChild2 = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild2PK);
		rootAChild2_Child2.setParentCategory(rootAChild2);
		categoryService.add(rootAChild2_Child2);
	}

	/**
	 * CAT-5
	 */
	@Test
	@Rollback(false)
	public void testDeleteCategory() {
		System.out.println("1-------------------");
		Category rootAChild2 = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild2PK);
		System.out.println("2-------------------");
		assertNotNull(rootAChild2);
		categoryService.delete(TestCaseConstants.CategoryConstant.rootAChild2PK);
		System.out.println("3------------------");
		Category _rootAChild2 = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild2PK);
		System.out.println("4------------------");
		assertNull(_rootAChild2);
		Category subCat = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild2_Child1PK);
		assertNull(subCat);
		System.out.println("5------------------");
	}

	/**
	 * CAT-6 Updating the name of a category and making sure the children still
	 * exist
	 */
	@Test
	public void testChangeCategory() {
		Category rootAChild3 = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild3PK);
		assertNotNull(rootAChild3);
		Category rootAChild1_newParent = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild1PK);
		assertNotNull(rootAChild1_newParent);
		rootAChild3.setParentCategory(rootAChild1_newParent);
		categoryService.update(rootAChild3);
		Category rootAChild3WithNewParent = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild3PK);
		assertNotNull(rootAChild3WithNewParent);
		Category parentCategory = rootAChild3WithNewParent.getParentCategory();
		assertEquals((long) parentCategory.getCategoryid(), TestCaseConstants.CategoryConstant.rootAChild1PK);
		List<Category> categories = rootAChild3WithNewParent.getCategories();
		assertNotNull(categories);
		assertEquals((long) categories.get(0).getCategoryid(), TestCaseConstants.CategoryConstant.rootAChild3_Child1PK);
	}

	/**
	 * CAT-7
	 *
	 */
	@Test
	// @Transactional
	// @Rollback(false)
	public void testUpdateCategory() {
		Category rootAChild1 = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild1PK);
		assertNotNull(rootAChild1);
		rootAChild1.setName(TestCaseConstants.CategoryConstant.rootAChild1 + "_updated");
		categoryService.update(rootAChild1);
		Category rootAChild1Updated = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild1PK);
		assertNotNull(rootAChild1Updated);
		assertEquals(TestCaseConstants.CategoryConstant.rootAChild1 + "_updated", rootAChild1Updated.getName());
		List<Category> categories = rootAChild1Updated.getCategories();
		assertNotNull(categories);
		boolean anyMatch = categories.stream()
				.anyMatch(e -> TestCaseConstants.CategoryConstant.rootAChild1_Child1.equals(e.getName()));
		assertTrue(anyMatch);
	}

}