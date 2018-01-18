package com.example.service;

import java.util.List;

import com.example.entity.Media;

public interface MediaService {
	   public void add(Media media);
	    public Media find(Long mediaid);

	    public Media find(String name);
	    
	    public void update(Media media);
	    public void delete(Long mediaid);
	    
	    public List<Media> listMedia();
}
