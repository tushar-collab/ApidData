package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired
	private HelloRepository helloRepository;
	
	public List<Topic> getTopics() {
		System.out.println("in service");
		List<Topic> topicsList = new ArrayList<>();
		helloRepository.findAll().forEach(topicsList::add);
		return topicsList;
	}

	public Topic getTopic(String id) {
		return helloRepository.findById(id).get();
	}

	public String addTopic(Topic topic) {
		try {
			helloRepository.save(topic);
			return "success";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	public void updateTopic(Topic topic, String id) {
		helloRepository.save(topic);
	}

	public String deleteTopic(String id) {
		String status = "fail";
		try {
			helloRepository.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
