package com.network.social.sn.post.dto;

public interface ListAll {

  Long getPostId();

  String getPostContent();

  String getPostImageUrl();

  int getLikes();

  int getComments();
}
