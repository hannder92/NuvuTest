package com.nuvu.usermanagement.persistence;

import com.nuvu.usermanagement.domain.User;
import com.nuvu.usermanagement.domain.repository.UserRepository;
import com.nuvu.usermanagement.persistence.crud.IUserRepository;
import com.nuvu.usermanagement.persistence.entity.UserEntity;
import com.nuvu.usermanagement.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class UserEntityRepository implements UserRepository {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAll() {
        return mapper.toUsers((List<UserEntity>) userRepository.findAll());
    }

    @Override
    public Optional<User> getById(String userId) {
        return userRepository.findById(userId).map(user -> mapper.toUser(user));
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = mapper.toUSerEntity(user);
        userEntity.setCreatedAt(LocalDateTime.now());
        return mapper.toUser(userRepository.save(userEntity));
    }

    @Override
    public void delete(String userId) {
        userRepository.deleteById(userId);
    }
}
