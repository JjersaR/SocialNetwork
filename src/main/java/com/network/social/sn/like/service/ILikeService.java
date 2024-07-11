package com.network.social.sn.like.service;

import com.network.social.sn.like.entity.Likes;

public interface ILikeService {

  void save(Likes like);

  void deleteById(Long id);
}
