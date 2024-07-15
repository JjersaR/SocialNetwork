package com.network.social.sn.post.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class IPostById implements Serializable {

  private Long id;

  private String userUsername;

  private String content;

  private String imageUrl;

  private LocalDate createdAt;

  private LocalDate updatedAt;

  private List<ListPostComments> comments;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserUsername() {
    return userUsername;
  }

  public void setUserUsername(String userUsername) {
    this.userUsername = userUsername;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDate getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDate updatedAt) {
    this.updatedAt = updatedAt;
  }

  public List<ListPostComments> getComments() {
    return comments;
  }

  public void setComments(List<ListPostComments> comments) {
    this.comments = comments;
  }
}
