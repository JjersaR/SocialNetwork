package com.network.social.sn.user.dto;

import java.io.Serializable;

public class ListAllUsers implements Serializable {

  private Long id;

  private String username;

  private String fullName;

  private String bio;

  private String email;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFullname() {
    return fullName;
  }

  public void setFullname(String fullName) {
    this.fullName = fullName;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
