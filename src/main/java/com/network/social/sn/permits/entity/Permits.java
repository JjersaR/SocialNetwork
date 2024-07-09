package com.network.social.sn.permits.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Permits")
public class Permits {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "permitID")
  private Long id;

  @Column(unique = true, nullable = false, updatable = false)
  @Enumerated(EnumType.STRING)
  private EPermits name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EPermits getName() {
    return name;
  }

  public void setName(EPermits name) {
    this.name = name;
  }
}
