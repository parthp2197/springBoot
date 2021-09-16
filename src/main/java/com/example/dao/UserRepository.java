package com.example.dao;

import java.util.List;

public interface UserRepository {

	public void insert(Object object);
	
	public List<Object> search(String query);
	
	public void delete(Object object);
}
