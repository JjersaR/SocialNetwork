package com.network.social.sn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.sn.user.service.impl.UserDetailServiceImpl;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private UserDetailServiceImpl userDetailsService;

}
