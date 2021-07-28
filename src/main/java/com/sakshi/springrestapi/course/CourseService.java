package com.sakshi.springrestapi.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
		// Accessing the data via JPA
	
		@Autowired
		CourseRepository CourseRepository;
		
		public CourseService() {
		}
		
		public List<Course> getAllCourses(String topicId) {
			List<Course> Courses = new ArrayList<>();
			CourseRepository.findByTopicId(topicId).forEach(Courses::add);
			return Courses;
		}
	
		public Optional<Course> getCourseById(String id) {
			return CourseRepository.findById(id);
		}

		public void addCourse(Course course) {
			CourseRepository.save(course);
		}

		public void updateCourse(Course course) {
			CourseRepository.save(course);
		}
		
		public void deleteCourse(String id) {
			CourseRepository.deleteById(id);
		}

}
