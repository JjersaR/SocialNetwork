package com.network.social.sn.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.network.social.sn.user.entity.Users;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {

  Optional<Users> findByUsername(String name);
}
