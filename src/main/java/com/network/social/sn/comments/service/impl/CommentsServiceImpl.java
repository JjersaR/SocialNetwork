package com.network.social.sn.comments.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.sn.comments.dto.IListPostComments;
import com.network.social.sn.comments.entity.Comments;
import com.network.social.sn.comments.repository.ICommentsRepository;
import com.network.social.sn.comments.service.ICommentsService;
import com.network.social.sn.controller.handleEx.ObjectWithoutContent;
import com.network.social.sn.controller.handleEx.ObjectWithoutFound;
import com.network.social.sn.post.repository.IPostRepository;
import com.network.social.sn.user.repository.IUserRepository;

@Service
public class CommentsServiceImpl implements ICommentsService {

  @Autowired
  private ICommentsRepository repository;

  @Autowired
  private IUserRepository userRepository;

  @Autowired
  private IPostRepository postRepository;

  @Override
  public List<IListPostComments> findByPostId(Long postId) {
    if (repository.findByPostId(postId).isEmpty()) {
      throw new ObjectWithoutContent("There are no comments on this post yet");
    }
    return repository.findByPostId(postId);
  }

  @Override
  public void save(Comments comment) {
    if (comment.getUser().getId() == null || comment.getPost().getId() == null) {
      throw new ObjectWithoutFound("The user and publication is required");
    } else if (!userRepository.findById(comment.getUser().getId()).isPresent()) {
      throw new ObjectWithoutFound("The user does not exist");
    } else if (!postRepository.findById(comment.getPost().getId()).isPresent()) {
      throw new ObjectWithoutFound("The publication does not exist");
    }
    repository.save(comment);
  }

  @Override
  public void deleteById(Long id) {
    if (!repository.findById(id).isPresent()) {
      throw new ObjectWithoutFound("The comment does not exist");
    }
    repository.deleteById(id);
  }
}
