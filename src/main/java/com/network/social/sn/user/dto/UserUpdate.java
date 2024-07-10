package com.network.social.sn.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class UserUpdate {

  @JsonIgnore
  private Long id;

  @Email
  @Nullable
  private String email;

  @Nullable
  @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{2,14}$", message = "Username must be 3 to 15 characters long, start with a letter, and can only contain letters, numbers, and underscores.")
  private String username;

  @Nullable
  @Pattern(regexp = "^([A-Z][a-z]*(\s+|\b)){2,}[A-Z][a-z]*$", message = "The name must be at least 3 words long.")
  private String fullName;

  @Nullable
  private String bio;

  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "The password must be at least 8 characters long, including at least one uppercase letter, one lowercase letter, one number and one symbol.")
  @Nullable
  private String password;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
