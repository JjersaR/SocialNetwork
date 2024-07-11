package com.network.social.sn.followers.service;

import java.util.List;

import com.network.social.sn.followers.dto.IListUsers;
import com.network.social.sn.followers.entity.Followers;

public interface IFollowerService {

  List<IListUsers> findUsersWhoFollowMe(Long id);

  List<IListUsers> findUsersIFollow(Long id);

  void save(Followers followers);

  void delete(Long id);
}
