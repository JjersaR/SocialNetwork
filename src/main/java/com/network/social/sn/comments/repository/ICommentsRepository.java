package com.network.social.sn.comments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.network.social.sn.comments.dto.IListPostComments;
import com.network.social.sn.comments.entity.Comments;

@Repository
public interface ICommentsRepository extends JpaRepository<Comments, Long> {

  @Query("SELECT c.id commentId, u.username, p.id postId, p.content postContent, p.imageUrl, GROUP_CONCAT(CONCAT('User: ', cu.username, ', Comment: ', c.content, ', Created At: ', c.createdAt, ', Updated At: ', c.updatedAt) SEPARATOR '; ') AS comments FROM Post p INNER JOIN Users u ON p.user_id = u.id LEFT JOIN Comments c ON c.post_id = p.id LEFT JOIN Users cu ON c.user_id = cu.id WHERE p.id = :postId GROUP BY c.id, u.username, p.id, p.content, p.imageUrl;")
  List<IListPostComments> findByPostId(Long postId);
}
