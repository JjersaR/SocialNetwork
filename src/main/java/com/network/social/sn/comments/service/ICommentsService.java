package com.network.social.sn.comments.service;

import java.util.List;

import com.network.social.sn.comments.dto.IListPostComments;
import com.network.social.sn.comments.entity.Comments;

public interface ICommentsService {

  List<IListPostComments> findByPostId(Long postId);

  void save(Comments comment);

  void deleteById(Long id);

  void deleteComment(Long commentId, Long userId, Long postId);
}
