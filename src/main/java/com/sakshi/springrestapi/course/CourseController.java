package com.sakshi.springrestapi.course;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.List;

import com.sakshi.springrestapi.topic.*;



@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping("topics/{topicId}/courses")
	public List<Course> getAllTopics(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("topics/{topicId}/courses/{id}")
	public Optional<Course> getTopicById(@PathVariable String id) {
		return courseService.getCourseById(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="topics/{topicId}/courses")
	public void addTopic(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	@RequestMapping(method=RequestMethod.PUT, value="topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
