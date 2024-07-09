package com.network.social.sn.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.network.social.sn.controller.dto.AuthLoginRequest;
import com.network.social.sn.controller.dto.AuthResponse;
import com.network.social.sn.user.repository.IUserRepository;
import com.network.social.sn.util.JwtUtils;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private IUserRepository repository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtUtils jwtUtils;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var users = repository.findByUsername(username).orElseThrow();
    List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

    users.getRoles()
        .forEach(
            role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getName().name()))));

    users.getRoles().stream().flatMap(role -> role.getPermitsSet().stream())
        .forEach(permit -> authorityList.add(new SimpleGrantedAuthority(permit.getName().name().toString())));

    return new User(users.getUsername(), users.getPassword(), users.isEnabled(), users.isAccountNoExpired(),
        users.isCredentialNoExpired(), users.isAccountNoLocked(), authorityList);
  }

  public AuthResponse loginUser(AuthLoginRequest request) {
    String username = request.username();
    String password = request.password();

    Authentication authentication = this.authenticate(username, password);
    SecurityContextHolder.getContext().setAuthentication(authentication);

    String accessToken = jwtUtils.createToken(authentication);

    return new AuthResponse(username, "User Loged Successfully", accessToken, true);
  }

  private Authentication authenticate(String username, String password) {
    UserDetails userDetails = this.loadUserByUsername(username);
    if (userDetails == null) {
      throw new BadCredentialsException("Invalid Username or Password");
    }

    if (!passwordEncoder.matches(password, userDetails.getPassword())) {
      throw new BadCredentialsException("Invalid password");
    }

    return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
  }

}
