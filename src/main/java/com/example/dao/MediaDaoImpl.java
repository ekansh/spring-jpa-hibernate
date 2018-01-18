package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.entity.Media;

/**
 * @author ekansh
 *
 */
@Repository
public class MediaDaoImpl implements MediaDao {

	@PersistenceContext
	private EntityManager em;


	@Override
	public Media find(long mediaid) {
		Media media = em.find(Media.class, mediaid);
		return media;
	}

	@Override
	public Media find(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Media> cq = cb.createQuery(Media.class);
		Root<Media> media = cq.from(Media.class);
		CriteriaQuery<Media> select = cq.select(media).where(cb.equal(media.get("name"), name));
		Media mediaRS = em.createQuery(select).getSingleResult();
		return mediaRS;
	}

	@Override
	public void add(Media thisMedia) {
		em.persist(thisMedia);
	}

	@Override
	public void delete(long mediaid) {
		Media media = find(mediaid);
		if (media!=null){
			System.out.println("media not null hence deleteing");
			em.remove(media);
			em.flush();
		}
	}

	@Override
	public void update(Media media) {
		em.merge(media);
	}

	@Override
	public List<Media> findAll() {
		CriteriaQuery<Media> criteriaQuery = em.getCriteriaBuilder().createQuery(Media.class);
//		@SuppressWarnings("unused")
//		Root<Media> root = criteriaQuery.from(Media.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

}
