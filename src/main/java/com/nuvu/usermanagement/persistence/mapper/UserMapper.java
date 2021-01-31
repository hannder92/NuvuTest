package com.nuvu.usermanagement.persistence.mapper;

import com.nuvu.usermanagement.domain.User;
import com.nuvu.usermanagement.persistence.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "cellphone", target = "cellphone"),
            @Mapping(source = "birthDate", target = "birthDate"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "creditCards", target = "creditCards")
    })
    User toUser(UserEntity userEntity);
    List<User> toUsers(List<UserEntity> userEntities);

    @InheritInverseConfiguration
    @Mapping(target = "creditCards", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    UserEntity toUSerEntity(User user);
}
