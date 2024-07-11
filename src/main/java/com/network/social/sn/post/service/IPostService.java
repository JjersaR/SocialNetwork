package com.network.social.sn.post.service;

import java.util.List;
import java.util.Optional;

import com.network.social.sn.post.dto.ListAll;
import com.network.social.sn.post.dto.PostUpdate;
import com.network.social.sn.post.entity.Post;

public interface IPostService {

  // find all
  List<ListAll> findAll();

  // find by id
  Optional<Post> findById(Long id);

  // save
  void save(Post post);

  // update
  void update(PostUpdate post);

  // delete by id
  void delete(Long id);
}
