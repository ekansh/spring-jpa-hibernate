package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.MediaDao;
import com.example.entity.Media;

/**
 * @author ekansh
 *
 */
@Service
public class MediaServiceImpl implements MediaService {

   @Autowired
   private MediaDao mediaDao;

   @Transactional
   @Override
   public void add(Media media) {
      mediaDao.add(media);
   }

   @Transactional(readOnly = true)
   @Override
   public List<Media> listMedia() {
      return mediaDao.listMedia();
   }

}
