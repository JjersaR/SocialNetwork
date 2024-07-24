package com.network.social.sn.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.network.social.sn.followers.repository.IFollowersRepository;
import com.network.social.sn.followers.dto.IListUsers;
import com.network.social.sn.followers.entity.Followers;
import com.network.social.sn.followers.service.impl.FollowerServiceImpl;
import com.network.social.sn.user.entity.Users;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

/**
 * FollowerServiceTest
 */
@ExtendWith(MockitoExtension.class)
public class FollowerServiceTest {

  @Mock
  private IFollowersRepository followersRepository;

  @InjectMocks
  private FollowerServiceImpl followerService;

  List<IListUsers> listUsers;

  @BeforeEach
  void setUp() {
    IListUsers listUsers1 = mock(IListUsers.class);
    IListUsers listUsers2 = mock(IListUsers.class);
    IListUsers listUsers3 = mock(IListUsers.class);

    lenient().when(listUsers1.getUsername()).thenReturn("username1");
    lenient().when(listUsers2.getUsername()).thenReturn("username2");
    lenient().when(listUsers3.getUsername()).thenReturn("username3");

    listUsers = List.of(listUsers1, listUsers2, listUsers3);

    lenient().when(followersRepository.findUsersWhoFollowMe(1L)).thenReturn(listUsers);
    lenient().when(followersRepository.findUsersIFollow(1L)).thenReturn(listUsers);
  }

  @Test
  void TestFindUsersWhoFollowMe() {
    // FollowerServiceTest#TestFindUsersWhoFollowMe
    var result = followerService.findUsersWhoFollowMe(1L);

    assertEquals(3, result.size());
    assertEquals("username1", result.get(0).getUsername());
    assertEquals("username2", result.get(1).getUsername());
    assertEquals("username3", result.get(2).getUsername());
  }

  @Test
  void TestFindUsersIFollow() {
    // FollowerServiceTest#TestFindUsersIFollow
    var result = followerService.findUsersIFollow(1L);

    assertEquals(3, result.size());
    assertEquals("username1", result.get(0).getUsername());
    assertEquals("username2", result.get(1).getUsername());
    assertEquals("username3", result.get(2).getUsername());
  }

  @Test
  void TestSave() {
    var followers = new Followers();
    var user1 = new Users();
    var user2 = new Users();

    user1.setId(1L);

    user2.setId(2L);

    followers.setId(1L);
    followers.setFollowee(user1);
    followers.setFollower(user2);

    lenient().when(followersRepository.save(followers)).thenReturn(followers);

    followerService.save(followers);
    verify(followersRepository).save(followers);
  }

  @Test
  void TestDeleteFollow() {
    followerService.deleteFollow(1L, 2L);
    verify(followersRepository).deleteByFolloweeAndFollower(1L, 2L);
  }
}
