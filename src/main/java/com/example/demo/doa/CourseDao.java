package com.example.demo.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Course;


@Repository
public interface CourseDao extends JpaRepository<Course, Long> {
    
}
