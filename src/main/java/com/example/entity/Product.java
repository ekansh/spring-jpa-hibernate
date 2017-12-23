package com.example.entity;

import java.util.List;
import javax.persistence.Entity;

//@Entity
public class Product {
	private String name;
	private String searchableTags;
	private String shortDescription;
	private String longDescription;
	private List<Media> media;
	private Float price;
	private Category category;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSearchableTags() {
		return searchableTags;
	}
	public void setSearchableTags(String searchableTags) {
		this.searchableTags = searchableTags;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public List<Media> getMedia() {
		return media;
	}
	public void setMedia(List<Media> media) {
		this.media = media;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
