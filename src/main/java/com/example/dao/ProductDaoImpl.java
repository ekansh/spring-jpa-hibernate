package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.entity.Media;
import com.example.entity.Person;
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
   public List<Product> listProduct() {
      CriteriaQuery<Product> criteriaQuery = em.getCriteriaBuilder().createQuery(Product.class);
      @SuppressWarnings("unused")
      Root<Product> root = criteriaQuery.from(Product.class);
      return em.createQuery(criteriaQuery).getResultList();
   }

}
