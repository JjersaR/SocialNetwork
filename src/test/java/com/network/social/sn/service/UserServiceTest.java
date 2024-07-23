package com.network.social.sn.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.network.social.sn.controller.handleEx.ObjectWithoutFound;
import com.network.social.sn.user.dto.IMyFollowers;
import com.network.social.sn.user.dto.UserUpdate;
import com.network.social.sn.user.entity.Users;
import com.network.social.sn.user.repository.IUserRepository;
import com.network.social.sn.user.service.impl.UserServiceImpl;

/**
 * UserRepositoryTest
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @Mock
  private IUserRepository userRepository;

  @InjectMocks
  private UserServiceImpl userService;

  private List<Users> users;

  private List<IMyFollowers> followers;

  @BeforeEach
  void setUp() {
    // list of users
    var asa = Users.builder()
        .id(1L)
        .username("Asa")
        .email("asa@gmail.com")
        .password("JjersaRBP")
        .fullName("Asa Rami Rora")
        .bio("Singer BM")
        .createdAt(LocalDate.now())
        .build();

    var rami = Users.builder()
        .id(2L)
        .username("Rami")
        .email("rami@gmail.com")
        .password("JjersaRBP")
        .fullName("Rami Asa Rora")
        .bio("Singer BM")
        .createdAt(LocalDate.now())
        .build();
    var rora = Users.builder()
        .id(3L)
        .username("Rora")
        .email("rora@gmail.com")
        .password("JjersaRBP")
        .fullName("Rora Rami Asa")
        .bio("Singer BM")
        .createdAt(LocalDate.now())
        .build();

    users = new ArrayList<>();
    users.add(asa);
    users.add(rami);
    users.add(rora);

    lenient().when(userRepository.findAll()).thenReturn(users);
  }

  @Test
  void TestFindAll() {
    var result = userService.findAll();

    assertEquals(3, result.size());
    assertEquals(1L, result.get(0).getId());
    assertEquals(2L, result.get(1).getId());
    assertEquals(3L, result.get(2).getId());
  }

  @Test
  void TestFindByUsername() {
    lenient().when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(users.get(0)));
    var result = userService.findById(1L);

    assertNotNull(result);
    assertEquals("Asa", result.getUsername());
    assertEquals(1L, result.getId());
  }

  @Test
  void TestFindFollowers() {
    IMyFollowers asaFollowers = mock(IMyFollowers.class);
    lenient().when(asaFollowers.getId()).thenReturn(users.get(0).getId());
    lenient().when(asaFollowers.getFollower()).thenReturn(users.get(0).getUsername());

    IMyFollowers ramiFollowers = mock(IMyFollowers.class);
    lenient().when(ramiFollowers.getId()).thenReturn(users.get(1).getId());
    lenient().when(ramiFollowers.getFollower()).thenReturn(users.get(1).getUsername());

    followers = new ArrayList<>();
    followers.add(asaFollowers);
    followers.add(ramiFollowers);

    lenient().when(userRepository.findFollowersByUserId(1L)).thenReturn(followers);

    var result = userService.findFollowers(1L);

    assertEquals(2, result.size());
    assertEquals(1L, result.get(0).getId());
    assertEquals(2L, result.get(1).getId());
    assertEquals("Asa", result.get(0).getFollower());
    assertEquals("Rami", result.get(1).getFollower());
  }

  @Test
  void TestSave() {
    var ruka = Users.builder()
        .id(1L)
        .username("Ruka")
        .email("ruka@gmail.com")
        .password("JjersaRBP")
        .fullName("Ruka Asa Rami")
        .bio("Singer BM")
        .createdAt(LocalDate.now())
        .build();

    lenient().when(userRepository.save(ruka)).thenReturn(ruka);

    userService.save(ruka);
    verify(userRepository).save(ruka);
  }

  @Test
  void TestUpdate() {
    var user = new UserUpdate();
    user.setId(1L);
    user.setBio("Singer Baby Monster");

    userService.update(user);
    verify(userRepository).update(user);
  }

  @Test
  void TestDeleteById() {
    var user = users.get(0);

    lenient().when(userRepository.findById(1L)).thenReturn(java.util.Optional.of((user)));

    userService.deleteById(1L);

    verify(userRepository).findById(1L);
    verify(userRepository).deleteById(1L);
  }

  @Test
  void TestDeleteByIdFailed() {
    lenient().when(userRepository.findById(4L)).thenReturn(java.util.Optional.empty());

    Exception exception = assertThrows(ObjectWithoutFound.class, () -> userService.deleteById(4L));
    assertEquals("This user was not found", exception.getMessage());
  }
}
