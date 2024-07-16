package com.network.social.sn.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.network.social.sn.like.entity.Likes;

import jakarta.transaction.Transactional;

@Repository
public interface ILikesRepository extends JpaRepository<Likes, Long> {

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM Likes l WHERE l.post_id = :postId AND l.user_id = :UserId", nativeQuery = true)
  void deleteLike(Long postId, Long UserId);
}
