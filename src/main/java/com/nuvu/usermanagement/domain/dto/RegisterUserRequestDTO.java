package com.nuvu.usermanagement.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public class RegisterUserRequestDTO {

	private String documentNumber;
	private String name;
	private String lastName;
	private String cellphone;
	private String email;
	private String address;
	private LocalDateTime bornDate;
	private List<CreditCardRequestDTO> creditCard;

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
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

	public List<CreditCardRequestDTO> getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(List<CreditCardRequestDTO> creditCard) {
		this.creditCard = creditCard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getBornDate() {
		return bornDate;
	}

	public void setBornDate(LocalDateTime bornDate) {
		this.bornDate = bornDate;
	}

}
