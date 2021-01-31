package com.nuvu.usermanagement.domain;

import com.nuvu.usermanagement.persistence.entity.UserEntity;
import com.nuvu.usermanagement.util.Utils;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreditCard {
    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @Digits(message = "card number should be contains only numbers", fraction = 0, integer = 16)
    @Size(message = "card number must be 16 digits", min = 16, max = 16)
    private String number;

    @NotNull(message = "card user name can not be empty or null")
    @Size(min = 5, message = "name must be at least 5 characters")
    private String username;

    @Pattern(regexp = "(0[1-9]|10|11|12)/[0-9]{2}$", message = "expiration date must be in format MM/yy")
    private String expirationDate;

    @Digits(message = "User id should be contains only numbers", fraction = 0, integer = 15)
    private String userId;

    @Digits(message = "cvv should be contains only numbers", fraction = 0, integer = 3)
    @Size(min = 3, max = 3, message = "Cvv must be 3 digits")
    private String cvv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
