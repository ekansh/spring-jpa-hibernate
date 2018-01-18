package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.entity.Product;

/**
 * @author ekansh
 *
 */
@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(Product product) {
		em.persist(product);
	}

	@Override
	public List<Product> findAll() {
		CriteriaQuery<Product> criteriaQuery = em.getCriteriaBuilder().createQuery(Product.class);
		@SuppressWarnings("unused")
		Root<Product> root = criteriaQuery.from(Product.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public Product find(long productid) {
		Product product = em.find(Product.class, productid);
		return product;
	}

	@Override
	public Product find(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> product = cq.from(Product.class);
		CriteriaQuery<Product> select = cq.select(product).where(cb.equal(product.get("name"), name));
		Product categoryRS = em.createQuery(select).getSingleResult();
		return categoryRS;
	}

	@Override
	public void delete(long productid) {
		Product product = find(productid);
		if (product != null) {
			System.out.println("product not null hence deleteing");
			em.remove(product);
//			em.flush();
		}
	}

	@Override
	public void update(Product product) {
		em.merge(product);
	}
}
