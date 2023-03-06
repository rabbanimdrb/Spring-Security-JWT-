package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Course;

public interface CourseService {
	
	public List<Course> getCourse();
	
	public Course getCourse(long courseId);

}
