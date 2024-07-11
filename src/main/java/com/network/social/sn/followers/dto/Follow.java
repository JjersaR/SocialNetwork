package com.network.social.sn.followers.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;

public class Follow {

  @NotNull
  private Long followerId;

  @NotNull
  private Long followeeId;

  @JsonIgnore
  private LocalDate createdAt = LocalDate.now();

  public Long getFollowerId() {
    return followerId;
  }

  public void setFollowerId(Long followerId) {
    this.followerId = followerId;
  }

  public Long getFolloweeId() {
    return followeeId;
  }

  public void setFolloweeId(Long followeeId) {
    this.followeeId = followeeId;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }
}
