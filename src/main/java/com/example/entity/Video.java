package com.example.entity;

import javax.persistence.Entity;

@Entity
public class Video extends Media{
	private Float length;

	public Float getLength() {
		return length;
	}

	public void setLength(Float length) {
		this.length = length;
	}
}
