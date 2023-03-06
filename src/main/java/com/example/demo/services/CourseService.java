package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Course;

public interface CourseService {
	
	public List<Course> getCourse();
	
	public Course getCourse(long courseId);
	
	public Course addCourse(Course course);

	public Course updateCourse(long courseId, Course course);

	public void removeCourse(long courseId);

}
