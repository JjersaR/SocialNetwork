package com.network.social.sn.followers.entity;

import java.time.LocalDate;

import com.network.social.sn.user.entity.Users;

import jakarta.persistence.*;

@Entity
@Table(name = "Followers", uniqueConstraints = { @UniqueConstraint(columnNames = { "follower", "followee" }) })
public class Followers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Mis seguidores
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  private Users follower;

  // a los que sigo
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  private Users followee;

  @Column(nullable = false, updatable = false)
  private LocalDate createdAt = LocalDate.now();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Users getFollower() {
    return follower;
  }

  public void setFollower(Users follower) {
    this.follower = follower;
  }

  public Users getFollowee() {
    return followee;
  }

  public void setFollowee(Users followee) {
    this.followee = followee;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }
}
