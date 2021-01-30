package com.nuvu.usermanagement.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nuvu.usermanagement.db.entity.User;

@Repository
public interface IUserRepository extends CrudRepository<User, String> {

}
