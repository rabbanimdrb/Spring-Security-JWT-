package com.example.demo.entities;

public class Course {
	
	private long id;
	private String title;
	private String desciption;
	
	public Course(long id, String title, String desciption) {
		super();
		this.id = id;
		this.title = title;
		this.desciption = desciption;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", desciption=" + desciption + "]";
	}

}
