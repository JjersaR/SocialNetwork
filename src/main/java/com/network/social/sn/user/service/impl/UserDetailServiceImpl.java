package com.network.social.sn.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.network.social.sn.user.repository.IUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private IUserRepository repository;

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

}
