package com.network.social.sn.followers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.network.social.sn.followers.dto.IListUsers;
import com.network.social.sn.followers.entity.Followers;

import jakarta.transaction.Transactional;

@Repository
public interface IFollowersRepository extends JpaRepository<Followers, Long> {

  @Query(value = "SELECT DISTINCT u.username, u.bio FROM Followers f JOIN Users u ON f.follower_id = u.id WHERE f.followee_id = :id", nativeQuery = true)
  List<IListUsers> findUsersWhoFollowMe(@Param("id") Long id);

  @Query(value = "SELECT DISTINCT u.username, u.bio FROM Followers f JOIN Users u ON f.followee_id = u.id WHERE f.follower_id = :id", nativeQuery = true)
  List<IListUsers> findUsersIFollow(@Param("id") Long id);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM Followers f WHERE f.followee_id = :followee AND f.follower_id = :follower", nativeQuery = true)
  void deleteByFolloweeAndFollower(@Param("followee") Long followee, @Param("follower") Long follower);
}
