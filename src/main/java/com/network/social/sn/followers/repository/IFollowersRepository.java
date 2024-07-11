package com.network.social.sn.followers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.network.social.sn.followers.dto.IListUsers;
import com.network.social.sn.followers.entity.Followers;

@Repository
public interface IFollowersRepository extends JpaRepository<Followers, Long> {

  @Query("SELECT DISTINCT u.username, u.bio FROM Followers f JOIN Users u ON f.follower_id = u.id WHERE f.followee_id = :id")
  List<IListUsers> findUsersWhoFollowMe(Long id);

  @Query("SELECT DISTINCT u.username, u.bio FROM Followers f JOIN Users u ON f.followee_id = u.id WHERE f.follower_id = :id")
  List<IListUsers> findUsersIFollow(Long id);
}
