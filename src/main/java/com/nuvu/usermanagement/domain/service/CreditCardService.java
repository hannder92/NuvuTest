package com.nuvu.usermanagement.domain.service;

import com.nuvu.usermanagement.domain.CreditCard;
import com.nuvu.usermanagement.domain.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<CreditCard> getAll(){
        return creditCardRepository.getAll();
    }
    public Optional<CreditCard> getById(long id){
        return creditCardRepository.findById(id);
    }

    public Optional<CreditCard> findByNumber(String number){
        return creditCardRepository.findByNumber(number);
    }

    public Optional<List<CreditCard>> findByUserId(String userId){
        return creditCardRepository.findByUserId(userId);
    }
    public CreditCard save(CreditCard creditCard){
        return creditCardRepository.save(creditCard);
    }
    public boolean deleteById(long id){
        return getById(id).map(creditCard -> {
            creditCardRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
