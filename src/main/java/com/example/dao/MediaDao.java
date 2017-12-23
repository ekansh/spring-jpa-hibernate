package com.example.dao;

import java.util.List;

import com.example.entity.Media;

public interface MediaDao {
   void add(Media media);
   List<Media> listMedia();
}
