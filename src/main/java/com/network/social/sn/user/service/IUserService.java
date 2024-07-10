package com.network.social.sn.user.service;

import java.util.List;

import com.network.social.sn.user.dto.IMyFollowers;
import com.network.social.sn.user.dto.UserUpdate;
import com.network.social.sn.user.entity.Users;

public interface IUserService {

  // find all
  List<Users> findAll();

  // find by id
  Users findById(Long id);

  // find followers
  List<IMyFollowers> findFollowers(Long id);

  // save
  void save(Users user);

  // update
  void update(UserUpdate user);

  // delete
  void deleteById(Long id);
}
