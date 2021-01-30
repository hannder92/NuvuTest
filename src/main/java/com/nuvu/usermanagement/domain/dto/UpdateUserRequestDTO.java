package com.nuvu.usermanagement.domain.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserRequestDTO {

	@NotNull(message = "cellphone can not be empty or null")
	@Digits(message = "cellphone should be contains only numbers", fraction = 0, integer = 10)
	private String cellphone;

	@NotNull(message = "name can not be empty or null")
	@Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email is not valid")
	private String email;

	@NotNull(message = "adress can not be empty or null")
	@Size(min = 5, message = "address must be at least 5 characters")
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
