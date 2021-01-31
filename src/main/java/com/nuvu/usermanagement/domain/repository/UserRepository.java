package com.nuvu.usermanagement.domain.repository;

import com.nuvu.usermanagement.domain.User;
import com.nuvu.usermanagement.domain.dto.UpdateUserRequestDTO;
import com.nuvu.usermanagement.persistence.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();
    Optional<User> getById(String userId);
    User save(User user);
    void delete(String userId);
    //User update(String id, UpdateUserRequestDTO user);
}
