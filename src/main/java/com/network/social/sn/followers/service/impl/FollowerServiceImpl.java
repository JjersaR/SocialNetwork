package com.network.social.sn.followers.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.sn.controller.handleEx.ObjectWithoutContent;
import com.network.social.sn.followers.dto.IListUsers;
import com.network.social.sn.followers.entity.Followers;
import com.network.social.sn.followers.repository.IFollowersRepository;
import com.network.social.sn.followers.service.IFollowerService;

@Service
public class FollowerServiceImpl implements IFollowerService {

  @Autowired
  private IFollowersRepository repository;

  @Override
  public List<IListUsers> findUsersWhoFollowMe(Long id) {
    if (repository.findUsersWhoFollowMe(id).isEmpty()) {
      throw new ObjectWithoutContent("No one is following you");
    }
    return repository.findUsersWhoFollowMe(id);
  }

  @Override
  public List<IListUsers> findUsersIFollow(Long id) {
    if (repository.findUsersIFollow(id).isEmpty()) {
      throw new ObjectWithoutContent("You do not follow anyone yet");
    }
    return repository.findUsersIFollow(id);
  }

  @Override
  public void save(Followers followers) {
    repository.save(followers);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Override
  public void deleteFollow(Long followee, Long follower) {
    repository.deleteByFolloweeAndFollower(followee, follower);
  }
}
