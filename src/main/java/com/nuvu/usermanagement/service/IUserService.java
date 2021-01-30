package com.nuvu.usermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.nuvu.usermanagement.db.entity.User;
import com.nuvu.usermanagement.domain.dto.UpdateUserRequestDTO;

public interface IUserService {

	List<User> getAll();

	Optional<User> findById(String id);

	boolean deleteById(String id);

	User save(User user);

	ResponseEntity<User> update(String id, UpdateUserRequestDTO user);

}
