package com.nuvu.usermanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuvu.usermanagement.db.entity.CreditCard;
import com.nuvu.usermanagement.db.repository.ICreditCardRepository;
import com.nuvu.usermanagement.service.ICreditCardService;

@Service
public class CreditCardServiceImpl implements ICreditCardService {

	@Autowired
	private ICreditCardRepository creditCardRepository;

	@Override
	public List<CreditCard> getAll() {
		return (List<CreditCard>) creditCardRepository.findAll();
	}

	@Override
	public Optional<CreditCard> findById(long id) {
		return creditCardRepository.findById(id);
	}

	@Override
	public Optional<List<CreditCard>> findByUserId(String userId) {
		return creditCardRepository.findByUserId(userId);
	}

	@Override
	public boolean deleteById(long id) {
		return findById(id).map(creditCard -> {
			creditCardRepository.delete(creditCard);
			return true;
		}).orElse(false);

	}

	@Override
	public CreditCard save(CreditCard creditCard) {
		return creditCardRepository.save(creditCard);
	}

}
