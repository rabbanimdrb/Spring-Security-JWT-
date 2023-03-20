package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.doa.CourseDao;
import com.example.demo.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	// List<Course> list;
	
	
	public CourseServiceImpl() {
		
		// list = new ArrayList<>();
		
		// list.add(new Course(101,"Java Core" ,"The is a basic course on JAVA"));
		// list.add(new Course(102, "Python", "This is a basic course on Python"));

	}
	

	@Override
	public List<Course> getCourse() {
		
		// return list;

		return courseDao.findAll();
	}


	@Override
	public Course getCourse(long courseId) {
		
		// Course c = null;
		// for(Course course : list) {
		// 	if(course.getId() == courseId) {
		// 		c = course;
		// 		break;
		// 	}
		// }
		// return c;


		return courseDao.findById(courseId).orElse(null); 
		
	}


	@Override
	public Course addCourse(Course course) {
		
		// list.add(course);

		courseDao.save(course);

		return course;
		
	}


	@Override
	public Course updateCourse(long courseId, Course course) {
		
		// for(Course course1 : list) {
		// 	if(course1.getId() == courseId) {
				
		// 		course1.setId(course.getId());
		// 		course1.setTitle(course.getTitle());
		// 		course1.setdescription(course.getdescription());
		// 	}
		// }

		courseDao.save(course);
		
		return course;
		
	}


	@Override
	public void removeCourse(long courseId) {
		
		// for(Course course : list) {
		// 	if(course.getId() == courseId) {
		// 		list.remove(course);
		// 	}
		// }

		Course course = courseDao.findById(courseId).orElse(null);
		courseDao.delete(course);
		
	}
	
}
