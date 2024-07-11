package com.network.social.sn.comments.dto;

public interface IListPostComments {

  Long getCommentId();

  String getUsername();

  Long getPostId();

  String getPostContent();

  String getImageUrl();

  String getComments();

}
