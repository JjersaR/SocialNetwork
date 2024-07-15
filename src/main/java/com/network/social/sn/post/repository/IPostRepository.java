package com.network.social.sn.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.network.social.sn.post.dto.ListAll;
import com.network.social.sn.post.dto.PostUpdate;
import com.network.social.sn.post.entity.Post;

import jakarta.transaction.Transactional;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {

  Optional<Post> findById(Long id);

  @Query(value = "SELECT p.id AS postId, p.content AS postContent, p.imageUrl AS postImageUrl, COUNT(DISTINCT l.id) AS likes, COUNT(DISTINCT c.content) AS comments FROM Post p LEFT JOIN Likes l ON l.post_id = p.id LEFT JOIN Comments c ON c.post_id = p.id GROUP BY p.id, p.content, p.imageUrl", nativeQuery = true)
  List<ListAll> findAllPost();

  @Transactional
  @Modifying
  @Query(value = "UPDATE Post p SET p.updatedAt = :#{#post.updatedAt}, p.user_id = :#{#post.userId}, p.content = COALESCE(:#{#post.content}, p.content), p.imageUrl = COALESCE(:#{#post.imageUrl}, p.imageUrl) WHERE p.id = :#{#post.postId}", nativeQuery = true)
  void update(PostUpdate post);
}
