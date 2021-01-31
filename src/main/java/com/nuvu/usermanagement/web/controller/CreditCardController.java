package com.nuvu.usermanagement.web.controller;

import java.util.List;

import com.nuvu.usermanagement.domain.CreditCard;
import com.nuvu.usermanagement.domain.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import javax.validation.Valid;

@RestController
@RequestMapping("/creditCards")
public class CreditCardController {

	@Autowired
	private CreditCardService creditCardService;

	@GetMapping()
	@ApiOperation(value = "Return all credit cards", authorizations = { @Authorization(value = "JWT") })
	@ApiResponse(code = 200, message = "OK")
	public List<CreditCard> getAll() {
		return creditCardService.getAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Return a credit card by ID", authorizations = { @Authorization(value = "JWT") })
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Credit card not found") })
	public ResponseEntity<CreditCard> getById(@PathVariable long id) {
		return creditCardService.getById(id).map(creditCard -> new ResponseEntity<>(creditCard, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/user/{id}")
	@ApiOperation(value = "Get a list of credit cards by user ID", authorizations = { @Authorization(value = "JWT") })
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "The user does not have any credit card") })
	public ResponseEntity<List<CreditCard>> getByUserId(@PathVariable(name = "id") String userId) {
		return creditCardService.findByUserId(userId)
				.map(creditCardList -> new ResponseEntity<>(creditCardList, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping()
	@ApiOperation(value = "Create a new credit card", authorizations = { @Authorization(value = "JWT") })
	@ApiResponse(code = 201, message = "CREATED")
	public ResponseEntity<CreditCard> save(@Valid @RequestBody CreditCard creditCard) {
		return new ResponseEntity(creditCardService.save(creditCard), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete credit card by ID", authorizations = { @Authorization(value = "JWT") })
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Credit card not exists") })
	public ResponseEntity<Void> delete(@PathVariable long id) {
		if (creditCardService.deleteById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
