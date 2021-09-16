package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.model.User;
import com.example.service.Service;

@RestController
public class HomeController {
	
	@Autowired
	Service service;
	
	//CrUd
	@PostMapping(value = "/createOrUpdate")
	public User create(User user) {
		service.insert(user);
		return user;
	}
	
	//cRud
	@GetMapping(value = "/index")
	public List<Object> index(Model model) {
		return fetchAllData(model);
	}
	
	//cruD
	@PostMapping( value = "/delete")
	public List<Object> delete(@RequestParam String id , Model model){
		List<Object> dataById = service.search("from User where id="+Integer.parseInt(id));
		User deleteUserById = (User) dataById.get(0);
		service.delete(deleteUserById);
		

		return fetchAllData(model);
	}
	
	@PostMapping( value = "/search")
	public User searchById(@RequestParam String id , Model model){
		List<Object> dataById = service.search("from User where id="+Integer.parseInt(id));
				

		return (User) dataById.get(0);
	}
	
	
	public List<Object> fetchAllData(Model model) {
		List<Object> allData  = service.search("from User");
		model.addAttribute("allData", allData);
		return allData;
		
	}


}
