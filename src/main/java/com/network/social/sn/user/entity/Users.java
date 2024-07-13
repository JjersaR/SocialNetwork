package com.network.social.sn.user.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.network.social.sn.comments.entity.Comments;
import com.network.social.sn.followers.entity.Followers;
import com.network.social.sn.like.entity.Likes;
import com.network.social.sn.post.entity.Post;
import com.network.social.sn.roles.entity.Roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Users")
public class Users {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 50)
  private String username;

  @Column(nullable = false, unique = true, length = 50)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(length = 100)
  private String fullName;

  @Column(columnDefinition = "TEXT")
  private String bio;

  @Column(columnDefinition = "DATE", updatable = false)
  private LocalDate createdAt;

  // SECURITY COLUMNS
  @Column(name = "is_enabled", columnDefinition = "BIT")
  private boolean isEnabled;

  @Column(name = "account_no_expired", columnDefinition = "BIT")
  private boolean accountNoExpired;

  @Column(name = "account_no_locked", columnDefinition = "BIT")
  private boolean accountNoLocked;

  @Column(name = "credential_no_expired", columnDefinition = "BIT")
  private boolean credentialNoExpired;

  // RELATIONS
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Post> posts;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Comments> comments;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Likes> likes;

  // Mis seguidores
  @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Followers> followers;

  // a los que sigo
  @OneToMany(mappedBy = "followee", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Followers> followees;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "User_ID"), inverseJoinColumns = @JoinColumn(name = "Rol_ID"))
  private Set<Roles> roles = new HashSet<>();

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public boolean isEnabled() {
    return isEnabled;
  }

  public void setEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public boolean isAccountNoExpired() {
    return accountNoExpired;
  }

  public void setAccountNoExpired(boolean accountNoExpired) {
    this.accountNoExpired = accountNoExpired;
  }

  public boolean isAccountNoLocked() {
    return accountNoLocked;
  }

  public void setAccountNoLocked(boolean accountNoLocked) {
    this.accountNoLocked = accountNoLocked;
  }

  public boolean isCredentialNoExpired() {
    return credentialNoExpired;
  }

  public void setCredentialNoExpired(boolean credentialNoExpired) {
    this.credentialNoExpired = credentialNoExpired;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  public List<Comments> getComments() {
    return comments;
  }

  public void setComments(List<Comments> comments) {
    this.comments = comments;
  }

  public List<Likes> getLikes() {
    return likes;
  }

  public void setLikes(List<Likes> likes) {
    this.likes = likes;
  }

  public List<Followers> getFollowers() {
    return followers;
  }

  public void setFollowers(List<Followers> followers) {
    this.followers = followers;
  }

  public List<Followers> getFollowees() {
    return followees;
  }

  public void setFollowees(List<Followers> followees) {
    this.followees = followees;
  }

  public Set<Roles> getRoles() {
    return roles;
  }

  public void setRoles(Set<Roles> roles) {
    this.roles = roles;
  }

}
