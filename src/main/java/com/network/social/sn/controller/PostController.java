package com.network.social.sn.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.sn.comments.dto.CommentSave;
import com.network.social.sn.comments.mapper.ICommentsMapper;
import com.network.social.sn.comments.service.ICommentsService;
import com.network.social.sn.controller.handleEx.ObjectWithoutFound;
import com.network.social.sn.post.dto.IPostById;
import com.network.social.sn.post.dto.ListAll;
import com.network.social.sn.post.dto.PostSave;
import com.network.social.sn.post.dto.PostUpdate;

import static com.network.social.sn.post.mapper.IPostMapper.INSTANCE;
import com.network.social.sn.post.service.IPostService;

import jakarta.validation.Valid;

@RestController
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/posts")
public class PostController {

  @Autowired
  private IPostService postService;

  @Autowired
  private ICommentsService commentService;

  @GetMapping("/all")
  public ResponseEntity<List<ListAll>> getAll() {
    return ResponseEntity.ok(postService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<IPostById> getById(@PathVariable Long id) {
    if (postService.findById(id).isEmpty()) {
      throw new ObjectWithoutFound("This post doesn't exist");
    }
    var post = postService.findById(id).get();
    return ResponseEntity.ok(INSTANCE.toPostDTO(post));
  }

  @PostMapping("{postId}/{userId}/comments")
  public ResponseEntity<String> addComment(@PathVariable Long postId, @PathVariable Long userId,
      @RequestBody @Valid CommentSave commentSave)
      throws URISyntaxException {
    commentSave.setPostId(postId);
    commentSave.setUserId(userId);
    commentService.save(ICommentsMapper.INSTANCE.toEntity(commentSave));
    return ResponseEntity.created(new URI("/posts/" + postId + "/comments")).body("Comment added");
  }

  @DeleteMapping("/{postId}/{userId}/comments/{commentId}")
  public ResponseEntity<String> deleteComment(@PathVariable Long postId, @PathVariable Long userId,
      @PathVariable Long commentId) {
    commentService.deleteComment(commentId, userId, postId);
    return ResponseEntity.ok("Comment " + commentId + " Deleted");
  }

  @PostMapping("")
  public ResponseEntity<String> createPost(@RequestBody @Valid PostSave postSave) throws URISyntaxException {
    postService.save(INSTANCE.toEntity(postSave));
    return ResponseEntity.created(new URI("/posts")).body("Post created");
  }

  @PutMapping("/{postId}/{userId}")
  public ResponseEntity<String> updatePost(@PathVariable Long postId, @PathVariable Long userId,
      @RequestBody @Valid PostUpdate postUpdate) {
    postUpdate.setPostId(postId);
    postUpdate.setUserId(userId);
    postService.update(postUpdate);
    return ResponseEntity.ok("Post " + postUpdate.getPostId() + " Updated");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePost(@PathVariable Long id) {
    postService.delete(id);
    return ResponseEntity.ok("Post " + id + " Deleted");
  }
}
