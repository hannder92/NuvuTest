package com.nuvu.usermanagement.domain;

import com.nuvu.usermanagement.persistence.entity.CreditCardEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

public class User {

    @NotNull(message = "id can not be null")
    @Digits(message = "document id should be contains only numbers", fraction = 0, integer = 15)
    private String id;

    @NotNull(message = "name can not be empty or null")
    @Size(min = 5, message = "name must be at least 5 characters")
    private String name;

    @NotNull(message = "lastname can not be empty or null")
    @Size(min = 5, message = "lastname must be at least 5 characters")
    private String lastName;

    @NotNull(message = "cellphone can not be empty or null")
    @Digits(message = "cellphone should be contains only numbers", fraction = 0, integer = 10)
    private String cellphone;

    @NotNull(message = "address can not be empty or null")
    @Size(min = 5, message = "address must be at least 5 characters")
    private String address;

    @Past(message = "birthDate must be earlier than actual date")
    private LocalDateTime birthDate;

    @NotNull(message = "name can not be empty or null")
    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email is not valid")
    private String email;

    @ApiModelProperty(required = false, hidden = true)
    List<CreditCardEntity> creditCards;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CreditCardEntity> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCardEntity> creditCards) {
        this.creditCards = creditCards;
    }
}
