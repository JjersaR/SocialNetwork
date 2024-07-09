package com.network.social.sn.like.entity;

import java.time.LocalDate;

import com.network.social.sn.post.entity.Post;
import com.network.social.sn.user.entity.Users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Likes", uniqueConstraints = { @UniqueConstraint(columnNames = { "post", "user" }) })
public class Likes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  private Post post;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  private Users user;

  @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDate createdAt = LocalDate.now();
}
