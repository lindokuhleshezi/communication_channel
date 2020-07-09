package com.channel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.channel.domain.Patient;
import com.channel.domain.Users;
import com.channel.exception.ResourceNotFoundException;
import com.channel.service.PatientService;
import com.channel.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	 private UsersService usersService;
	
	@GetMapping
	public List<Users> getPatients(){
		return this.usersService.findAll();
	}
	
	@GetMapping("/{id}")
	public Users getPatient(String id) throws ResourceNotFoundException {
		return this.usersService.findById(id);
	}
	
	@PostMapping
	public void save(@RequestBody Users users){
		 this.usersService.save(users);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(String id) throws ResourceNotFoundException{
		 this.usersService.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public Users update(@PathVariable String id, @RequestBody Users users) throws ResourceNotFoundException{
		return this.usersService.update(id,users);
	}
}
