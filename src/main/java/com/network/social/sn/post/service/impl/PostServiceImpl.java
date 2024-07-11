package com.network.social.sn.post.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.network.social.sn.controller.handleEx.ObjectWithoutContent;
import com.network.social.sn.controller.handleEx.ObjectWithoutFound;
import com.network.social.sn.post.dto.ListAll;
import com.network.social.sn.post.dto.PostUpdate;
import com.network.social.sn.post.entity.Post;
import com.network.social.sn.post.repository.IPostRepository;
import com.network.social.sn.post.service.IPostService;

@Service
public class PostServiceImpl implements IPostService {

  @Autowired
  private IPostRepository repository;

  @Override
  public List<ListAll> findAll() {
    if (repository.findAllPost().isEmpty()) {
      throw new ObjectWithoutContent("There are no posts");
    }
    return repository.findAllPost();
  }

  @Override
  public Optional<Post> findById(Long id) {
    if (repository.findById(id).isEmpty()) {
      throw new ObjectWithoutFound("This post does not exist");
    }
    return repository.findById(id);
  }

  @Override
  public void save(Post post) {
    repository.save(post);
  }

  @Override
  public void update(PostUpdate post) {
    if (post.getPostId() == null) {
      throw new ObjectWithoutFound("This post does not exist");
    }
    repository.update(post);
  }

  @Override
  public void delete(Long id) {
    if (repository.findById(id).isEmpty()) {
      throw new ObjectWithoutFound("This post does not exist");
    }
    repository.deleteById(id);
  }

}
