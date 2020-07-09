package com.channel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channel.dao.UsersDAO;
import com.channel.domain.Users;
import com.channel.exception.ResourceNotFoundException;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDAO usersDao;

	@Override
	public List<Users> findAll() {
		return this.usersDao.findAll();
	}

	@Override
	public Users findById(String id) throws ResourceNotFoundException {
		return this.usersDao.findById(id).get();
	}

	@Override
	public void save(Users users) {
		this.usersDao.save(users);

	}

	@Override
	public Users update(String id, Users users) throws ResourceNotFoundException {
		Optional<Users> usersData = this.usersDao.findById(id);
		if (!usersData.isPresent()) {
			throw new ResourceNotFoundException("");
		}
		users.setId(usersData.get().getId());
		usersDao.save(users);
		return users;
	}

	@Override
	public void delete(String id) throws ResourceNotFoundException {
		Optional<Users> usersData = this.usersDao.findById(id);
		if (!usersData.isPresent()) {
			throw new ResourceNotFoundException("");
		}
		usersDao.delete(usersData.get());

	}

}
