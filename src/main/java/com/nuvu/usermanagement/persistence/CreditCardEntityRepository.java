package com.nuvu.usermanagement.persistence;

import com.nuvu.usermanagement.domain.CreditCard;
import com.nuvu.usermanagement.domain.repository.CreditCardRepository;
import com.nuvu.usermanagement.persistence.crud.ICreditCardRepository;
import com.nuvu.usermanagement.persistence.entity.CreditCardEntity;
import com.nuvu.usermanagement.persistence.mapper.CreditCardMapper;
import com.nuvu.usermanagement.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CreditCardEntityRepository implements CreditCardRepository {

    @Autowired
    private ICreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardMapper mapper;

    @Override
    public List<CreditCard> getAll() {
        return mapper.toCreditCards((List<CreditCardEntity>) creditCardRepository.findAll());
    }

    @Override
    public Optional<CreditCard> findById(long id) {
        return creditCardRepository.findById(id).map(creditCard -> mapper.toCreditCard(creditCard));
    }

    @Override
    public Optional<CreditCard> findByNumber(String number) {
        return creditCardRepository.findByNumber(number).map(creditCard -> mapper.toCreditCard(creditCard));
    }

    @Override
    public Optional<List<CreditCard>> findByUserId(String userId) {
        return creditCardRepository.findByUserId(userId).map(creditCards -> mapper.toCreditCards(creditCards));
    }

    @Override
    public CreditCard save(CreditCard creditCard) {
        CreditCardEntity creditCardEntity = mapper.toCreditCardEntity(creditCard);
        try {
            creditCardEntity.setNumber(Utils.cipher(creditCard.getNumber()));
            creditCardEntity.setCvv(Utils.cipher(creditCard.getCvv()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapper.toCreditCard(creditCardRepository.save(creditCardEntity));
    }

    @Override
    public void delete(long id) {
        creditCardRepository.deleteById(id);
    }



}
