package com.nuvu.usermanagement.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nuvu.usermanagement.persistence.entity.UserEntity;

public interface IUserRepository extends CrudRepository<UserEntity, String> {

}
