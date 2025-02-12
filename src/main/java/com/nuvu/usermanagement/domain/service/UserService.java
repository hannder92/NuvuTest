package com.nuvu.usermanagement.domain.service;

import com.nuvu.usermanagement.domain.User;
import com.nuvu.usermanagement.domain.dto.UpdateUserRequestDTO;
import com.nuvu.usermanagement.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getById(String userId) {
        return userRepository.getById(userId);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(String userId, UpdateUserRequestDTO request) {
        return getById(userId).map(user -> {
            user.setAddress(request.getAddress());
            user.setCellphone(request.getCellphone());
            user.setEmail(request.getEmail());
            return userRepository.save(user);
        }).orElse(null);

    }

    public boolean delete(String userId) {
        return getById(userId).map(user -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }


}
