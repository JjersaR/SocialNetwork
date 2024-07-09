package com.network.social.sn.roles.entity;

import java.util.HashSet;
import java.util.Set;

import com.network.social.sn.permits.entity.Permits;

import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Roles {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Rol_ID", unique = true)
  private long id;

  @Column(nullable = false, length = 50, unique = true)
  @Enumerated(EnumType.STRING)
  private ERole name;

  // PERMITS
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "roles_permits", joinColumns = @JoinColumn(name = "Rol_ID"), inverseJoinColumns = @JoinColumn(name = "Permit_ID"))
  private Set<Permits> permitsSet = new HashSet<>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public ERole getName() {
    return name;
  }

  public void setName(ERole name) {
    this.name = name;
  }

  public Set<Permits> getPermitsSet() {
    return permitsSet;
  }

  public void setPermitsSet(Set<Permits> permitsSet) {
    this.permitsSet = permitsSet;
  }
}
