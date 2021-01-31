package com.nuvu.usermanagement.domain.repository;

import com.nuvu.usermanagement.domain.CreditCard;
import com.nuvu.usermanagement.persistence.entity.CreditCardEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CreditCardRepository {

    List<CreditCard> getAll();
    Optional<CreditCard> findById(long id);
    Optional<CreditCard> findByNumber(String number);
    Optional<List<CreditCard>> findByUserId(String userId);
    CreditCard save(CreditCard creditCard);
    void delete(long id);

}
