package com.nuvu.usermanagement.web.controller;

import java.util.List;

import javax.validation.Valid;

import com.nuvu.usermanagement.domain.service.UserService;
import com.nuvu.usermanagement.domain.User;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuvu.usermanagement.domain.dto.UpdateUserRequestDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping()
	@ApiOperation(value = "Return all users", authorizations = { @Authorization(value = "JWT") })
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "") })
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Return user by id", authorizations = { @Authorization(value = "JWT") })
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "") })
	public ResponseEntity<User> getUser(@PathVariable(name = "id") String userId) {
		return userService.getById(userId).map(user -> new ResponseEntity<>(user, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update user", authorizations = { @Authorization(value = "JWT") })
	@ApiResponses({ @ApiResponse(code = 200, message = "OK",response = User.class), @ApiResponse(code = 404, message = "") })
	public ResponseEntity<User> updateUser(@PathVariable String id, @Valid @RequestBody UpdateUserRequestDTO request) {
		User user = userService.update(id, request);
		if(user!= null){
			return new ResponseEntity<>(user, HttpStatus.OK);
		}else{
			return new ResponseEntity("User does not exist",HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping()
	@ApiOperation(value = "Create user", authorizations = { @Authorization(value = "JWT") })
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "") })
	public ResponseEntity<Object> createUser(@Valid @RequestBody User User) {
		return new ResponseEntity<>(userService.save(User),HttpStatus.CREATED);
	}

	@ApiOperation(value = "Delete user by id", authorizations = { @Authorization(value = "JWT") })
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "") })
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		if (userService.delete(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
