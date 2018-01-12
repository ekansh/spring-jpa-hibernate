package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.config.AppConfig;
import com.example.entity.Category;
import com.example.entity.Image;
import com.example.entity.Media;
import com.example.entity.Product;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class CategoryServiceTest extends TestCase {
	@Autowired
	CategoryService categoryService;

	public CategoryServiceTest() {
	}

	@PersistenceContext
	private  EntityManager em;

	@Transactional
	@Before
	public  void setUp() {
//		System.out.println("Setting up DB for the testing Category entity");
//
//		Category rootA = new Category();
//		rootA.setName(TestCaseConstants.CategoryConstant.rootA);
//		rootA.setCategoryid(TestCaseConstants.CategoryConstant.rootAPK);
//
//		Category rootAChild1 = new Category();
//		rootAChild1.setName(TestCaseConstants.CategoryConstant.rootAChild1);
//		rootAChild1.setCategoryid(TestCaseConstants.CategoryConstant.rootAChild1PK);
//
//		Category rootAChild2 = new Category();
//		rootAChild2.setCategoryid(TestCaseConstants.CategoryConstant.rootAChild2PK);
//		rootAChild2.setName(TestCaseConstants.CategoryConstant.rootAChild2);
//
//		Category rootAChild3 = new Category();
//		rootAChild3.setCategoryid(TestCaseConstants.CategoryConstant.rootAChild3PK);
//		rootAChild3.setName(TestCaseConstants.CategoryConstant.rootAChild3);
//
//		Category rootAChild1_Child1 = new Category();
//		rootAChild1_Child1.setName(TestCaseConstants.CategoryConstant.rootAChild1_Child1);
//		rootAChild1_Child1.setCategoryid(TestCaseConstants.CategoryConstant.rootAChild1_Child1PK);
//
//		Category rootAChild2_Child1 = new Category();
//		rootAChild2_Child1.setName(TestCaseConstants.CategoryConstant.rootAChild2_Child1);
//		rootAChild2_Child1.setCategoryid(TestCaseConstants.CategoryConstant.rootAChild2_Child1PK);
//
//		Category rootAChild3_Child1 = new Category();
//		rootAChild3_Child1.setName(TestCaseConstants.CategoryConstant.rootAChild3_Child1);
//		rootAChild3_Child1.setCategoryid(TestCaseConstants.CategoryConstant.rootAChild3_Child1PK);
//
//		rootA.addCategories(rootAChild1);
//		rootA.addCategories(rootAChild2);
//		rootA.addCategories(rootAChild3);
//		rootAChild1.addCategories(rootAChild1_Child1);
//		rootAChild2.addCategories(rootAChild2_Child1);
//		rootAChild3.addCategories(rootAChild3_Child1);
//		em.persist(rootA);
//		System.out.println("Database ready for test");
	}

//	@Transactional
//	@After
//	public void tearDown() {
//		Category categoryRS = em.find(Category.class, TestCaseConstants.CategoryConstant.rootAPK);
//		em.remove(categoryRS);
//		System.out.println("database cleared off test data belonging to Category entity");
//	}
//
//	/**
//	 * CAT-1
//	 */
//	@Test
//	@Transactional
//	public void testFindCategoryBasedOnID() {
//		// TODO: check the transaction propgation default category
//		Category rootAChild1 = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild1PK);
//		assertNotNull(rootAChild1);
//		assertEquals(TestCaseConstants.CategoryConstant.rootAChild1, rootAChild1.getName());
//		Category rootA = rootAChild1.getParentCategory();
//		assertNotNull(rootA);
//		assertEquals(TestCaseConstants.CategoryConstant.rootAPK, (long) rootA.getCategoryid());
//		assertEquals("parent category name mismatch", TestCaseConstants.CategoryConstant.rootA, rootA.getName());
//	}
//
//	/**
//	 * CAT-2
//	 */
//	@Test
//	@Transactional
//	public void testFindCategoryBasedOnName() {
//		Category rootAChild1 = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild1);
//		assertNotNull(rootAChild1);
//		assertEquals(TestCaseConstants.CategoryConstant.rootAChild1PK, (long) rootAChild1.getCategoryid());
//		Category rootA = rootAChild1.getParentCategory();
//		assertNotNull(rootA);
//		assertEquals(TestCaseConstants.CategoryConstant.rootAPK, (long) rootA.getCategoryid());
//		assertEquals(TestCaseConstants.CategoryConstant.rootA, rootA.getName());
//	}
//
//	/**
//	 * CAT-4
//	 */
//	@Test
//	@Transactional
//	public void testAddCategoryUsingParentCategoryId() {
//		System.out.println("adding a sub category to " + TestCaseConstants.CategoryConstant.rootAChild2);
//		Category rootAChild2_Child2 = new Category();
//		rootAChild2_Child2.setName(TestCaseConstants.CategoryConstant.rootAChild2_Child2);
//		Category rootAChild2 = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild2PK);
//		rootAChild2_Child2.setParentCategory(rootAChild2);
//		categoryService.add(rootAChild2_Child2);
//	}

	/**
	 * CAT-5
	 */
	@Test
	@Transactional
	public void testDeleteCategoryy() {
		Category rootAChild2 = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild2PK);
		assertNotNull(rootAChild2);
		categoryService.delete(TestCaseConstants.CategoryConstant.rootAChild2PK);
		Category _rootAChild2 = categoryService.find(973L);
		assertNull(_rootAChild2);
		Category subCat = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild2_Child1PK);
		assertNull(subCat);
	}

//	/**
//	 * CAT-6 Updating the name of a category and making sure the children still exist
//	 */
//	@Test
//	@Transactional
//	public void testChangeCategory() {
//		Category rootAChild3 = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild3PK);
//		assertNotNull(rootAChild3);
//		Category rootAChild1_newParent = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild1PK);
//		assertNotNull(rootAChild1_newParent);
//		rootAChild3.setParentCategory(rootAChild1_newParent);
//		categoryService.add(rootAChild3);
//		categoryService.update(rootAChild3);
//		Category rootAChild3WithNewParent = categoryService.find(TestCaseConstants.CategoryConstant.rootAChild3PK);
//
//		assertNotNull(rootAChild3WithNewParent);
//		Category parentCategory = rootAChild3WithNewParent.getParentCategory();
//		assertEquals((long) parentCategory.getCategoryid(), TestCaseConstants.CategoryConstant.rootAChild1PK);
//		List<Category> categories = rootAChild3WithNewParent.getCategories();
//		assertNotNull(categories);
//		assertEquals((long) categories.get(0).getCategoryid(), TestCaseConstants.CategoryConstant.rootAChild3_Child1PK);
//	}

	/**
	 * CAT-7 
	 * 
	 */
	@Test
	@Transactional
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
		assertEquals(TestCaseConstants.CategoryConstant.rootAChild1_Child1,categories.get(0).getName());
	}

}