package com.example.demo.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends CrudRepository <Topic,String>{

	
	
	
}
