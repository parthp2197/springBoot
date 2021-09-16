package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.UserRepository;
import com.example.model.User;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	UserRepository dao;
	
	@Transactional
	public void insert(User user) {
		dao.insert(user);
	}
	
	@Transactional
	public List<Object> search(String query){
		return dao.search(query);
	}
	
	@Transactional
	public void delete(Object object) {
		dao.delete(object);
	}
	
}



	

