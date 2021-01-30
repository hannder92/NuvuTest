package com.nuvu.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuvu.usermanagement.domain.dto.AuthenticationRequest;
import com.nuvu.usermanagement.domain.dto.AuthenticationResponse;
import com.nuvu.usermanagement.security.JWTUtil;
import com.nuvu.usermanagement.service.impl.NuvuUserDetailsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private NuvuUserDetailsService nuvuUserDetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("/authenticate")
	@ApiOperation(value = "Authenticate user")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 403, message = "Forbidden") })
	public ResponseEntity<AuthenticationResponse> createToken(
			@ApiParam(name = "Credentials") @RequestBody(required = true) AuthenticationRequest request) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			UserDetails userDetails = nuvuUserDetailsService.loadUserByUsername(request.getUsername());
			String jwt = jwtUtil.generateToken(userDetails);
			return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
}