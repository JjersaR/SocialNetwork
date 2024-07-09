package com.network.social.sn.roles.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.network.social.sn.roles.entity.ERole;
import com.network.social.sn.roles.entity.Roles;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Long> {

  Roles findByName(ERole rol);
}
