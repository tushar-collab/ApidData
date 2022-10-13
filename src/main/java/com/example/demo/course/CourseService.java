package com.example.demo.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getCourses(String topicId) {
		System.out.println("in service");
		List<Course> courseList = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courseList::add);
		return courseList;
	}

	public Course getCourse(String id) {
		return courseRepository.findById(id).get();
	}

	public String addCourse(Course course) {
		try {
			courseRepository.save(course);
			return "success";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	public void updateCourse(Course topic, String id) {
		courseRepository.save(topic);
	}

	public String deleteCourse(String id) {
		String status = "fail";
		try {
			courseRepository.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
