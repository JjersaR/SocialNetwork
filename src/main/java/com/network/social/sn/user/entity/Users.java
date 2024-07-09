package com.network.social.sn.user.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.network.social.sn.comments.entity.Comments;
import com.network.social.sn.followers.entity.Followers;
import com.network.social.sn.like.entity.Likes;
import com.network.social.sn.post.entity.Post;
import com.network.social.sn.roles.entity.Roles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
  private LocalDate createdAt = LocalDate.now();

  // SECURITY COLUMNS
  @Column(name = "is_enabled", columnDefinition = "BIT")
  private boolean isEnabled = true;

  @Column(name = "account_no_expired", columnDefinition = "BIT")
  private boolean accountNoExpired = true;

  @Column(name = "account_no_locked", columnDefinition = "BIT")
  private boolean accountNoLocked = true;

  @Column(name = "credential_no_expired", columnDefinition = "BIT")
  private boolean credentialNoExpired = true;

  // RELATIONS
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Post> posts = new ArrayList<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Comments> comments = new ArrayList<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Likes> likes = new ArrayList<>();

  @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Followers> followers = new ArrayList<>();

  @OneToMany(mappedBy = "followee", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Followers> followees = new ArrayList<>();

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "User_ID"), inverseJoinColumns = @JoinColumn(name = "Rol_ID"))
  private Set<Roles> roles = new HashSet<>();

}
