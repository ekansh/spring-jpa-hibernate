package com.example.dao;

import java.util.List;

import com.example.entity.Media;

public interface MediaDao {
	Media find(long mediaid);
	Media find(String name);
	void add(Media thisMedia);
	void delete(long mediaid);
	void update (Media media); 
	public List<Media> findAll();
}
