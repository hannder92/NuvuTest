package com.nuvu.usermanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nuvu.usermanagement.db.entity.User;
import com.nuvu.usermanagement.db.repository.IUserRepository;
import com.nuvu.usermanagement.domain.dto.UpdateUserRequestDTO;
import com.nuvu.usermanagement.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public List<User> getAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Optional<User> findById(String id) {
		return userRepository.findById(id);

	}

	@Override
	public boolean deleteById(String id) {
		return findById(id).map(user -> {
			userRepository.delete(user);
			return true;
		}).orElse(false);

	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public ResponseEntity<User> update(String id, UpdateUserRequestDTO user) {
		return findById(id).map(userToUpdate -> {
			userToUpdate.setName(user.getName());
			userToUpdate.setLastName(user.getLastName());
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setCellphone(user.getCellphone());
			userToUpdate.setAddress(user.getAddress());
			userRepository.save(userToUpdate);
			return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
