package com.nuvu.usermanagement.persistence.mapper;

import com.nuvu.usermanagement.domain.CreditCard;
import com.nuvu.usermanagement.persistence.entity.CreditCardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreditCardMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "number", target = "number"),
            @Mapping(source = "expirationDate", target = "expirationDate"),
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "cvv", target = "cvv"),
            @Mapping(source = "username", target = "username"),
    })
    CreditCard toCreditCard(CreditCardEntity creditCardEntity);
    List<CreditCard> toCreditCards(List<CreditCardEntity> creditCardEntities);

    CreditCardEntity toCreditCardEntity(CreditCard creditCard);

}
