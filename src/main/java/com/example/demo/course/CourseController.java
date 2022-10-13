package com.example.demo.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getCourses(@PathVariable String topicId){
		System.out.println("in controller");
		return courseService.getCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getTopic(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public String addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		String res = courseService.addCourse(course);
		return res;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public String deleteTopic(@PathVariable String id) {
		String status = courseService.deleteCourse(id);
		return status;
	}
}
