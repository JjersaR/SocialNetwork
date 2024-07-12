package com.network.social.sn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.sn.controller.dto.AuthCreateUser;
import com.network.social.sn.controller.dto.AuthLoginRequest;
import com.network.social.sn.controller.dto.AuthResponse;
import com.network.social.sn.user.service.impl.UserDetailServiceImpl;

import jakarta.validation.Valid;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private UserDetailServiceImpl userDetailsService;

  // the user exist in DB
  @PostMapping("/log-in")
  public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest loginRequest) {
    return new ResponseEntity<>(this.userDetailsService.loginUser(loginRequest), HttpStatus.OK);
  }

  // the user dont exist in BD
  @PostMapping("sign-up")
  public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUser authCreateUser) {
    return new ResponseEntity<>(this.userDetailsService.createUser(authCreateUser), HttpStatus.CREATED);
  }
}
