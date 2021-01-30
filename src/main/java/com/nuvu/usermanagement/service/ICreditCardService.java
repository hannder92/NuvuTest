package com.nuvu.usermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.nuvu.usermanagement.db.entity.CreditCard;

public interface ICreditCardService {

	Optional<CreditCard> findById(long id);

	Optional<CreditCard> findByNumber(String number);

	List<CreditCard> getAll();

	Optional<List<CreditCard>> findByUserId(String id);

	boolean deleteById(long id);

	ResponseEntity<Object> save(CreditCard creditCard);

}
