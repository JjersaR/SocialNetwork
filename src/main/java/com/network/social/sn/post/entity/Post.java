package com.network.social.sn.post.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.network.social.sn.comments.entity.Comments;
import com.network.social.sn.like.entity.Likes;
import com.network.social.sn.user.entity.Users;

import jakarta.persistence.*;

@Entity
@Table(name = "Post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, targetEntity = Users.class)
  @JoinColumn(nullable = false)
  private Users user;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  @Column(length = 255)
  private String imageUrl;

  @Column(nullable = false, updatable = false)
  private LocalDate createdAt = LocalDate.now();

  private LocalDate updatedAt = LocalDate.now();

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Comments> comments = new ArrayList<>();

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Likes> likes = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Users getUser() {
    return user;
  }

  public void setUser(Users user) {
    this.user = user;
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
}
