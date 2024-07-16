package com.network.social.sn.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.sn.like.dto.LikeSave;
import static com.network.social.sn.like.mapper.ILikeMapper.INSTANCE;
import com.network.social.sn.like.service.ILikeService;

@RestController
@RequestMapping("/like")
@PreAuthorize("hasRole('ROLE_USER')")
public class LikeController {

  @Autowired
  private ILikeService likeService;

  @PostMapping("/{postId}/post/{userId}/user")
  public ResponseEntity<String> likePost(@PathVariable Long postId, @PathVariable Long userId)
      throws URISyntaxException {

    var dto = new LikeSave();
    dto.setPostId(postId);
    dto.setUserId(userId);

    likeService.save(INSTANCE.toEntity(dto));

    return ResponseEntity.created(new URI("/like/" + postId + "/post")).body("Like Post " + postId);
  }

  @DeleteMapping("/{postId}/post/{userId}/user")
  public ResponseEntity<String> deleteLikePost(@PathVariable Long postId, @PathVariable Long userId) {
    likeService.deleteLike(postId, userId);
    return ResponseEntity.ok("Delete Like Post " + postId);
  }
}
