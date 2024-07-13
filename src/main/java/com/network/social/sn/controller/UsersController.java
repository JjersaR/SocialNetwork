package com.network.social.sn.controller;

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

import com.network.social.sn.followers.dto.Follow;
import com.network.social.sn.followers.mapper.IFollowerMapper;
import com.network.social.sn.followers.service.IFollowerService;
import com.network.social.sn.user.dto.IMyFollowers;
import com.network.social.sn.user.dto.ListAllUsers;
import com.network.social.sn.user.dto.UserUpdate;

import static com.network.social.sn.user.mapper.IUserMapper.INSTANCE;
import com.network.social.sn.user.service.IUserService;

import jakarta.validation.Valid;

@RestController
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/users")
public class UsersController {

  @Autowired
  private IUserService userService;

  @Autowired
  private IFollowerService followersService;

  @GetMapping("")
  public ResponseEntity<List<ListAllUsers>> getAll() {
    return ResponseEntity.ok(INSTANCE.toUserListDTO(userService.findAll()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ListAllUsers> getById(@PathVariable Long id) {
    return ResponseEntity.ok(INSTANCE.toUserDTO(userService.findById(id)));
  }

  @GetMapping("{id}/followers")
  public ResponseEntity<List<IMyFollowers>> getFollowers(@PathVariable Long id) {
    return ResponseEntity.ok(userService.findFollowers(id));
  }

  // id -> person I unfollowed followerId -> my id
  @PostMapping("{id}/followers/{followerId}")
  public ResponseEntity<String> followUser(@PathVariable Long id, @PathVariable Long followerId) {
    var follow = new Follow();
    follow.setFollowerId(id);
    follow.setFolloweeId(followerId);
    followersService.save(IFollowerMapper.INSTANCE.toEntity(follow));
    return ResponseEntity.ok("You Followed " + follow.getFolloweeId());
  }

  @DeleteMapping("{id}/unfollowed/{followerId}")
  public ResponseEntity<String> deleteFollow(@PathVariable Long id, @PathVariable Long followerId) {
    followersService.deleteFollow(id, followerId);
    return ResponseEntity.ok("You Unfollowed " + followerId);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> update(@PathVariable Long id, @RequestBody @Valid UserUpdate userUpdate) {
    userUpdate.setId(id);
    userService.update(userUpdate);
    return ResponseEntity.ok("User " + id + " Updated Successfully");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    userService.deleteById(id);
    return ResponseEntity.ok("User " + id + " Deleted Successfully");
  }
}
