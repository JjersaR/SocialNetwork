package com.network.social.sn.service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.network.social.sn.comments.dto.IListPostComments;
import com.network.social.sn.comments.entity.Comments;
import com.network.social.sn.user.entity.Users;
import com.network.social.sn.comments.repository.ICommentsRepository;
import com.network.social.sn.comments.service.impl.CommentsServiceImpl;
import com.network.social.sn.controller.handleEx.ObjectWithoutFound;
import com.network.social.sn.post.entity.Post;
import com.network.social.sn.post.repository.IPostRepository;
import com.network.social.sn.user.repository.IUserRepository;

/**
 * CommentServiceTest
 */
@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {

  @Mock
  private ICommentsRepository commentsRepository;

  @Mock
  private IPostRepository postRepository;

  @Mock
  private IUserRepository userRepository;

  @InjectMocks
  private CommentsServiceImpl commentService;

  List<IListPostComments> listComments;

  Comments comment;
  Users user;
  Post post;

  Long id = 1L;

  @BeforeEach
  void setUp() {
    comment = new Comments();
    user = new Users();
    post = new Post();

    user.setId(id);
    post.setId(id);

    comment.setId(id);
    comment.setUser(user);
    comment.setPost(post);

    IListPostComments postComments1 = mock(IListPostComments.class);
    IListPostComments postComments2 = mock(IListPostComments.class);
    IListPostComments postComments3 = mock(IListPostComments.class);

    lenient().when(postComments1.getCommentId()).thenReturn(id);
    lenient().when(postComments2.getCommentId()).thenReturn(2L);
    lenient().when(postComments3.getCommentId()).thenReturn(3L);

    listComments = List.of(postComments1, postComments2, postComments3);

    lenient().when(commentsRepository.findByPostId(id)).thenReturn(listComments);
  }

  @Test
  void TestFindByPostId() {
    var result = commentService.findByPostId(id);

    assertEquals(3, result.size());
    assertEquals(1, result.get(0).getCommentId());
    assertEquals(2, result.get(1).getCommentId());
    assertEquals(3, result.get(2).getCommentId());
  }

  @Test
  void TestSaveCommentUserOrPostIdNull() {
    var commentSaved = new Comments();
    user.setId(null);
    post.setId(null);
    commentSaved.setUser(user);
    commentSaved.setPost(post);

    lenient().doThrow(new ObjectWithoutFound("The user and publication is required")).when(commentsRepository)
        .save(commentSaved);

    Exception exception = assertThrows(ObjectWithoutFound.class, () -> commentService.save(comment));
    assertEquals("The user and publication is required", exception.getMessage());
  }

  @Test
  void TestSaveCommentUserNotFound() {
    lenient().when(userRepository.findById(id)).thenReturn(Optional.empty());

    Exception exception = assertThrows(ObjectWithoutFound.class, () -> commentService.save(comment));
    assertEquals("The user does not exist", exception.getMessage());
  }

  @Test
  void TestSaveCommentPostNotFound() {
    lenient().when(userRepository.findById(id)).thenReturn(Optional.of(user));
    lenient().when(postRepository.findById(id)).thenReturn(Optional.empty());

    Exception exception = assertThrows(ObjectWithoutFound.class, () -> commentService.save(comment));
    assertEquals("The publication does not exist", exception.getMessage());
  }

  @Test
  void TestSaveCommentSuccess() {
    lenient().when(userRepository.findById(id)).thenReturn(Optional.of(user));
    lenient().when(postRepository.findById(id)).thenReturn(Optional.of(post));

    commentService.save(comment);

    verify(commentsRepository).save(comment);
  }

  @Test
  void TestDeleteByIdCommentNotFound() {
    lenient().when(commentsRepository.findById(id)).thenReturn(Optional.empty());

    Exception exception = assertThrows(ObjectWithoutFound.class, () -> commentService.deleteById(id));
    assertEquals("The comment does not exist", exception.getMessage());
  }

  @Test
  void TestDeleteByIdSuccess() {
    lenient().when(commentsRepository.findById(id)).thenReturn(Optional.of(comment));

    commentService.deleteById(id);

    verify(commentsRepository).deleteById(id);
  }

  @Test
  void TestDeleteCommentCommentNotFound() {
    lenient().when(commentsRepository.findById(id)).thenReturn(Optional.empty());

    Exception exception = assertThrows(ObjectWithoutFound.class,
        () -> commentService.deleteComment(comment.getId(), user.getId(), post.getId()));

    assertEquals("The comment does not exist", exception.getMessage());
  }

  @Test
  void TestDeleteCommentUserNotFound() {
    lenient().when(commentsRepository.findById(id)).thenReturn(Optional.of(comment));
    lenient().when(userRepository.findById(id)).thenReturn(Optional.empty());

    Exception exception = assertThrows(ObjectWithoutFound.class,
        () -> commentService.deleteComment(comment.getId(), user.getId(), post.getId()));

    assertEquals("The user does not exist", exception.getMessage());
  }

  @Test
  void TestDeleteCommentPostNotFound() {
    lenient().when(commentsRepository.findById(id)).thenReturn(Optional.of(comment));
    lenient().when(userRepository.findById(id)).thenReturn(Optional.of(user));
    lenient().when(postRepository.findById(id)).thenReturn(Optional.empty());

    Exception exception = assertThrows(ObjectWithoutFound.class,
        () -> commentService.deleteComment(comment.getId(), user.getId(), post.getId()));

    assertEquals("This post does not exist", exception.getMessage());
  }

  @Test
  void TestDeleteCommentSuccess() {
    lenient().when(commentsRepository.findById(id)).thenReturn(Optional.of(comment));
    lenient().when(userRepository.findById(id)).thenReturn(Optional.of(user));
    lenient().when(postRepository.findById(id)).thenReturn(Optional.of(post));

    commentService.deleteComment(comment.getId(), user.getId(), post.getId());

    verify(commentsRepository).deleteComment(comment.getId(), user.getId(), post.getId());
  }
}
