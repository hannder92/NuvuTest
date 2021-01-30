package com.nuvu.usermanagement.service;

import java.util.List;
import java.util.Optional;

import com.nuvu.usermanagement.db.entity.CreditCard;

public interface ICreditCardService {

	Optional<CreditCard> findById(long id);

	List<CreditCard> getAll();

	Optional<List<CreditCard>> findByUserId(String id);

	boolean deleteById(long id);

	CreditCard save(CreditCard creditCard);

}
