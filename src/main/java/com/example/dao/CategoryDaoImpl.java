package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.entity.Category;
import com.example.entity.Media;
import com.example.entity.Person;

/**
 * @author ekansh
 *
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	private EntityManager em;


	@Override
	public Category find(long categoryid) {
		Category category = em.find(Category.class, categoryid);
		return category;
	}

	@Override
	public Category find(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Category> cq = cb.createQuery(Category.class);
		Root<Category> category = cq.from(Category.class);
		CriteriaQuery<Category> select = cq.select(category).where(cb.equal(category.get("name"), name));
		Category categoryRS = em.createQuery(select).getSingleResult();
		return categoryRS;
	}

	@Override
	public void add(Category thisCategory) {
		em.persist(thisCategory);
	}

	@Override
	public void delete(long categoryid) {
		Category category = find(categoryid);
		if (category!=null){
			System.out.println("category not null hence deleteing");
			em.remove(category);
			em.flush();
		}
	}

	@Override
	public void update(Category category) {
		em.merge(category);
//		em.flush();
	}

	@Override
	public List<Category> findAll() {
		CriteriaQuery<Category> criteriaQuery = em.getCriteriaBuilder().createQuery(Category.class);
//		@SuppressWarnings("unused")
//		Root<Category> root = criteriaQuery.from(Category.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

}
