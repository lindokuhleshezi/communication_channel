package com.channel.service;

import java.util.List;

import com.channel.domain.Users;
import com.channel.exception.ResourceNotFoundException;

public interface UsersService {
	
	List<Users> findAll();
	Users findById(String id) throws ResourceNotFoundException;;
	void save(Users users);
	Users update(String id,Users users)throws ResourceNotFoundException;
	void delete(String id) throws ResourceNotFoundException;
}
