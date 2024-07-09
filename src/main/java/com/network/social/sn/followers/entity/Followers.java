package com.network.social.sn.followers.entity;

import java.time.LocalDate;

import com.network.social.sn.user.entity.Users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Followers", uniqueConstraints = { @UniqueConstraint(columnNames = { "follower", "followee" }) })
public class Followers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  private Users follower;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  private Users followee;

  @Column(nullable = false, updatable = false)
  private LocalDate createdAt = LocalDate.now();
}
