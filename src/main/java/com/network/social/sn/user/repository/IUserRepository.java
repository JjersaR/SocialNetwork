package com.network.social.sn.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.network.social.sn.user.dto.IMyFollowers;
import com.network.social.sn.user.dto.UserUpdate;
import com.network.social.sn.user.entity.Users;

import jakarta.transaction.Transactional;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {

  Optional<Users> findByUsername(String name);

  Optional<Users> findById(Long id);

  @Query(value = "SELECT DISTINCT u.id, u.username follower, u.fullName, u.bio FROM Users u INNER JOIN Followers f WHERE f.follower_id = :id", nativeQuery = true)
  List<IMyFollowers> findFollowersByUserId(Long id);

  @Transactional
  @Modifying
  @Query("UPDATE Users u SET u.email = COALESCE(:#{#user.email}, u.email), u.username = COALESCE(:#{#user.username}, u.username), u.fullName = COALESCE(:#{#user.fullName}, u.fullName), u.bio = COALESCE(:#{#user.bio}, u.bio), u.password = COALESCE(:#{#user.password}, u.password) WHERE u.id = :#{#user.id}")
  void update(@Param("user") UserUpdate user);
}
