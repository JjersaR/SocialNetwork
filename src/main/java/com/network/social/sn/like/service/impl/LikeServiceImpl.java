package com.network.social.sn.like.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.network.social.sn.like.entity.Likes;
import com.network.social.sn.like.repository.ILikesRepository;
import com.network.social.sn.like.service.ILikeService;

public class LikeServiceImpl implements ILikeService {

  @Autowired
  private ILikesRepository repository;

  @Override
  public void save(Likes like) {
    repository.save(like);
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

}
