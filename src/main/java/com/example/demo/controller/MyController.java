package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Course;
import com.example.demo.services.CourseService;


@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "This is a home page";
	}
	
//	localhost:8080/courses
	@GetMapping("/courses")
	public List<Course> getCourse(){
		
		return this.courseService.getCourse();
		
	}
	
//	localhost:8080/courses/102
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		
		return this.courseService.getCourse(Long.parseLong(courseId));
		
	}
	
}
