package com.network.social.sn.like.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.sn.controller.handleEx.ObjectWithoutFound;
import com.network.social.sn.like.entity.Likes;
import com.network.social.sn.like.repository.ILikesRepository;
import com.network.social.sn.like.service.ILikeService;
import com.network.social.sn.post.repository.IPostRepository;
import com.network.social.sn.user.repository.IUserRepository;

@Service
public class LikeServiceImpl implements ILikeService {

  @Autowired
  private ILikesRepository repository;

  @Autowired
  private IPostRepository postRepository;

  @Autowired
  private IUserRepository userRepository;

  @Override
  public void save(Likes like) {
    repository.save(like);
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  @Override
  public void deleteLike(Long postId, Long UserId) {
    if (!postRepository.findById(postId).isPresent()) {
      throw new ObjectWithoutFound("This post doesn't exist");
    }
    if (!userRepository.findById(UserId).isPresent()) {
      throw new ObjectWithoutFound("This user doesn't exist");

    }
    repository.deleteLike(postId, UserId);
  }

}
