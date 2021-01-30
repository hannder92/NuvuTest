package com.nuvu.usermanagement.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nuvu.usermanagement.db.entity.CreditCard;

@Repository
public interface ICreditCardRepository extends CrudRepository<CreditCard, Long> {

	public Optional<List<CreditCard>> findByUserId(String userId);

}
