package com.network.social.sn.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.network.social.sn.controller.handleEx.ObjectWithoutFound;
import com.network.social.sn.like.entity.Likes;
import com.network.social.sn.like.repository.ILikesRepository;
import com.network.social.sn.like.service.impl.LikeServiceImpl;
import com.network.social.sn.post.entity.Post;
import com.network.social.sn.post.repository.IPostRepository;
import com.network.social.sn.user.entity.Users;
import com.network.social.sn.user.repository.IUserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

/**
 * LikeServiceTest
 */
@ExtendWith(MockitoExtension.class)
public class LikeServiceTest {

  @Mock
  private ILikesRepository likeRepository;

  @Mock
  private IUserRepository userRepository;

  @Mock
  private IPostRepository postRepository;

  @InjectMocks
  private LikeServiceImpl likeService;

  Users user;
  Post post;
  Likes likeSave;

  @BeforeEach
  void setUp() {
    user = new Users();
    post = new Post();
    likeSave = new Likes();

    // user id
    user.setId(1L);
    // post id
    post.setId(2L);
    // relation
    likeSave.setId(1L);
    likeSave.setUser(user);
    likeSave.setPost(post);
  }

  @Test
  void TestSave() {
    lenient().when(likeRepository.save(likeSave)).thenReturn(likeSave);

    likeService.save(likeSave);
    verify(likeRepository).save(likeSave);
  }

  @Test
  void TestDeleteById() {
    lenient().when(likeRepository.findById(1L)).thenReturn(Optional.of(likeSave));

    likeService.deleteById(1L);

    verify(likeRepository).findById(1L);
    verify(likeRepository).deleteById(1L);
  }

  @Test
  void TestDeleteByIdFailed() {
    lenient().when(likeRepository.findById(3L)).thenReturn(Optional.empty());

    Exception exception = assertThrows(ObjectWithoutFound.class, () -> likeService.deleteById(3L));
    assertEquals("This like doesn't exist", exception.getMessage());
  }

  @Test
  void TestDeleteLike() {
    lenient().when(userRepository.findById(1L)).thenReturn(Optional.of(user));
    lenient().when(postRepository.findById(2L)).thenReturn(Optional.of(post));

    likeService.deleteLike(2L, 1L);

    verify(userRepository).findById(1L);
    verify(postRepository).findById(2L);
    verify(likeRepository).deleteLike(2L, 1L);
  }

  @Test
  void TestDeleteLikeFailedWithUserNotFound() {
    lenient().when(postRepository.findById(2L)).thenReturn(Optional.of(post));
    lenient().when(userRepository.findById(3L)).thenReturn(Optional.empty());
    doThrow(new ObjectWithoutFound("This user doesn't exist")).when(userRepository).findById(3L);

    Exception exception = assertThrows(ObjectWithoutFound.class, () -> likeService.deleteLike(2L, 3L));
    assertEquals("This user doesn't exist", exception.getMessage());
  }

  @Test
  void TestDeleteLikeFailedWithPostNotFound() {
    lenient().when(postRepository.findById(3L)).thenReturn(Optional.empty());
    lenient().when(userRepository.findById(1L)).thenReturn(Optional.of(user));
    doThrow(new ObjectWithoutFound("This post doesn't exist")).when(postRepository).findById(3L);

    Exception exception = assertThrows(ObjectWithoutFound.class, () -> likeService.deleteLike(3L, 1L));
    assertEquals("This post doesn't exist", exception.getMessage());
  }
}
