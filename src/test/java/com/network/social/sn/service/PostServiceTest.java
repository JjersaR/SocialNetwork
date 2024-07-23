package com.network.social.sn.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import com.network.social.sn.controller.handleEx.ObjectWithoutFound;
import com.network.social.sn.post.dto.ListAll;
import com.network.social.sn.post.dto.PostUpdate;
import com.network.social.sn.post.entity.Post;
import com.network.social.sn.post.repository.IPostRepository;
import com.network.social.sn.post.service.impl.PostServiceImpl;

/**
 * PostServiceTest
 */
@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

  @Mock
  private IPostRepository postRepository;

  @InjectMocks
  private PostServiceImpl postService;

  List<ListAll> listPosts;

  @Test
  void TestFindAll() {
    ListAll post1 = mock(ListAll.class);
    ListAll post2 = mock(ListAll.class);
    ListAll post3 = mock(ListAll.class);
    lenient().when(post1.getPostId()).thenReturn(1L);
    lenient().when(post2.getPostId()).thenReturn(2L);
    lenient().when(post3.getPostId()).thenReturn(3L);

    listPosts = List.of(post1, post2, post3);

    // findAll
    lenient().when(postRepository.findAllPost()).thenReturn(listPosts);

    var result = postService.findAll();

    assertEquals(3, result.size());
    assertEquals(1, result.get(0).getPostId());
    assertEquals(2, result.get(1).getPostId());
    assertEquals(3, result.get(2).getPostId());
  }

  @Test
  void TestFindById() {
    var post = new Post();
    post.setId(1L);
    post.setContent("Test with Mockito");

    lenient().when(postRepository.findById(1L)).thenReturn(Optional.of(post));

    var result = postService.findById(1L).get();

    assertNotNull(result);
    assertEquals(1, result.getId());
    assertEquals("Test with Mockito", result.getContent());
  }

  @Test
  void TestSave() {
    var post = new Post();
    post.setId(2L);
    post.setContent("Test with Mockito");

    lenient().when(postRepository.save(post)).thenReturn(post);

    postService.save(post);
    verify(postRepository).save(post);
  }

  @Test
  void TestUpdate() {
    var post = new PostUpdate();
    post.setPostId(2L);
    post.setContent("Test with Mockito in Neovim");

    postService.update(post);
    verify(postRepository).update(post);
  }

  @Test
  void TestDelete() {
    var post = new Post();
    post.setId(1L);

    lenient().when(postRepository.findById(1L)).thenReturn(Optional.of(post));

    postService.delete(post.getId());

    verify(postRepository).findById(1L);
    verify(postRepository).deleteById(1L);
  }

  @Test
  void TestDeleteByIdFailed() {
    lenient().when(postRepository.findById(5L)).thenReturn(Optional.empty());

    Exception exception = assertThrows(ObjectWithoutFound.class, () -> postService.delete(5L));
    assertEquals("This post does not exist", exception.getMessage());
  }

}
