package com.network.social.sn.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.network.social.sn.controller.handleEx.ObjectWithoutContent;
import com.network.social.sn.controller.handleEx.ObjectWithoutFound;
import com.network.social.sn.user.dto.IMyFollowers;
import com.network.social.sn.user.dto.UserUpdate;
import com.network.social.sn.user.entity.Users;
import com.network.social.sn.user.repository.IUserRepository;
import com.network.social.sn.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserRepository repository;

  @Override
  public List<Users> findAll() {
    if (repository.findAll().isEmpty()) {
      throw new ObjectWithoutFound("There are no users");
    }
    return repository.findAll();
  }

  @Override
  public Users findById(Long id) {
    if (repository.findById(id).isEmpty()) {
      throw new ObjectWithoutFound("This user was not found");
    }
    return repository.findById(id).get();
  }

  @Override
  public List<IMyFollowers> findFollowers(Long id) {
    if (repository.findFollowersByUserId(id).isEmpty()) {
      throw new ObjectWithoutFound("There are no followers");

    }
    return repository.findFollowersByUserId(id);
  }

  @Override
  public void save(Users user) {
    var passwordDes = user.getPassword();
    user.setPassword(new BCryptPasswordEncoder().encode(passwordDes));
    repository.save(user);
  }

  @Override
  public void update(UserUpdate user) {
    if (user.getId() == null) {
      throw new ObjectWithoutContent("User id is required");
    }
    repository.update(user);
  }

  @Override
  public void deleteById(Long id) {
    var usOP = repository.findById(id);
    if (!usOP.isPresent()) {
      throw new ObjectWithoutFound("This user was not found");
    }
    repository.deleteById(id);
  }

}
