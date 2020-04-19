package com.eqap.poc.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eqap.poc.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	@Query( "SELECT c.courseId AS courseId, c.name AS name, c.fees AS fees, c.institute.name AS instituteName FROM Course AS c" )
	public List<Map<String,Object>> getCourses() ;
	
		
	

}
