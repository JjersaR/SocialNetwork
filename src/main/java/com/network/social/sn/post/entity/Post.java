package com.network.social.sn.post.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.network.social.sn.comments.entity.Comments;
import com.network.social.sn.like.entity.Likes;
import com.network.social.sn.user.entity.Users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

  @Column(nullable = false)
  private LocalDate updatedAt = LocalDate.now();

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Comments> comments = new ArrayList<>();

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Likes> likes = new ArrayList<>();
}
