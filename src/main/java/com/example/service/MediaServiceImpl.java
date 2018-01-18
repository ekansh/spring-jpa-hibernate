package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.MediaDao;
import com.example.dao.MediaDao;
import com.example.entity.Media;
import com.example.entity.Media;

/**
 * @author ekansh
 *
 */
@Service
public class MediaServiceImpl implements MediaService {

	@Autowired
	private MediaDao mediaDao;

	@Override
	@Transactional
	public void add(Media media) {
		mediaDao.add(media);
	}

	@Transactional(readOnly = true)
	@Override
	public Media find(Long mediaid) {
		Media find = mediaDao.find(mediaid);
		return find;
	}

	@Transactional
	@Override
	public Media find(String name) {
		Media find = mediaDao.find(name);
		return find;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void update(Media media) {
		mediaDao.update(media);
	}

	@Transactional
	@Override
	public void delete(Long mediaid) {
		mediaDao.delete(mediaid);
	}

	@Transactional
	@Override
	public List<Media> listMedia() {
		return mediaDao.findAll();
	}
}
