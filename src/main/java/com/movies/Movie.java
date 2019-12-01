package com.movies;

import java.util.List;

public class Movie {

	private String name;
	private String imageName;
	private int score;
	private List<String> lstActors;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<String> getLstActors() {
		return lstActors;
	}

	public void setLstActors(List<String> lstActors) {
		this.lstActors = lstActors;
	}

}
