package com.nuvu.usermanagement.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nuvu.usermanagement.persistence.entity.CreditCardEntity;

public interface ICreditCardRepository extends CrudRepository<CreditCardEntity, Long> {

	public Optional<List<CreditCardEntity>> findByUserId(String userId);

	public Optional<CreditCardEntity> findByNumber(String number);

}
