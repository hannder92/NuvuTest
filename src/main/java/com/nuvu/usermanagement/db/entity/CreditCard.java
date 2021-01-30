package com.nuvu.usermanagement.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "credit_card")
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(required = false, hidden = true)
	private Long id;

	@Column(unique = true)
	@Digits(message = "card number should be contains only numbers", fraction = 0, integer = 16)
	private String number;

	@NotNull(message = "card user name can not be empty or null")
	@Size(min = 5, message = "name must be at least 5 characters")
	private String username;

	@Column(name = "expiration_date")
	@Pattern(regexp = "(0[1-9]|10|11|12)/[0-9]{2}$", message = "expiration date must be in format MM/yy")
	private String expirationDate;

	@Column(name = "user_id")
	@Digits(message = "User id should be contains only numbers", fraction = 0, integer = 15)
	private String userId;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;

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

}
