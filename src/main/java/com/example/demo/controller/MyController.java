package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
//	localhost:8080/courses
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseService.addCourse(course);
	}
	
	
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@PathVariable String courseId , @RequestBody Course course) {
		
		this.courseService.updateCourse(Long.parseLong(courseId), course);
		
		return course;
		
	}
	
	@DeleteMapping("/courses/{courseId}")
	public void removeCourse(@PathVariable String courseId) {
		this.courseService.removeCourse(Long.parseLong(courseId));
//		return "The course is deleted successfully";
	}
	
}
