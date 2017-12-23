package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.entity.Media;
import com.example.entity.Person;

/**
 * @author ekansh
 *
 */
@Repository
public class MediaDaoImpl implements MediaDao {

   @PersistenceContext
   private EntityManager em;

   @Override
   public void add(Media media) {
      em.persist(media);
   }

   @Override
   public List<Media> listMedia() {
      CriteriaQuery<Media> criteriaQuery = em.getCriteriaBuilder().createQuery(Media.class);
      @SuppressWarnings("unused")
      Root<Media> root = criteriaQuery.from(Media.class);
      return em.createQuery(criteriaQuery).getResultList();
   }

}
