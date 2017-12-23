package com.example.service;

import java.util.List;

import com.example.entity.Media;

public interface MediaService {
    void add(Media media);
    List<Media> listMedia();
}
