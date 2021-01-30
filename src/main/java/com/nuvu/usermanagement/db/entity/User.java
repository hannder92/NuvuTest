package com.nuvu.usermanagement.db.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "user")
public class User {

	@Id
	@NotNull(message = "id can not be null")
	@Digits(message = "document id should be contains only numbers", fraction = 0, integer = 15)
	private String id;

	@NotNull(message = "name can not be empty or null")
	@Size(min = 5, message = "name must be at least 5 characters")
	private String name;

	@NotNull(message = "lastname can not be empty or null")
	@Size(min = 5, message = "lastname must be at least 5 characters")
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message = "cellphone can not be empty or null")
	@Digits(message = "cellphone should be contains only numbers", fraction = 0, integer = 10)
	@Column(unique = true)
	private String cellphone;

	@NotNull(message = "address can not be empty or null")
	@Size(min = 5, message = "address must be at least 5 characters")
	private String address;

	@Past(message = "birthDate must be earlier than actual date")
	@Column(name = "birth_date")
	private LocalDateTime birthDate;

	@NotNull(message = "name can not be empty or null")
	@Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email is not valid")
	@Column(unique = true)
	private String email;

	@Column(name = "created_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt;

	@ApiModelProperty(required = false, hidden = true)
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	List<CreditCard> creditCards;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
