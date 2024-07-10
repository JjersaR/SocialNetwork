package com.network.social.sn.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.network.social.sn.user.dto.ListAllUsers;
import com.network.social.sn.user.entity.Users;

@Mapper
public interface IUserMapper {

  IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

  // List all
  ListAllUsers toUserDTO(Users user);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "isEnabled", ignore = true)
  @Mapping(target = "accountNoExpired", ignore = true)
  @Mapping(target = "accountNoLocked", ignore = true)
  @Mapping(target = "credentialNoExpired", ignore = true)
  @Mapping(target = "posts", ignore = true)
  @Mapping(target = "comments", ignore = true)
  @Mapping(target = "likes", ignore = true)
  @Mapping(target = "followers", ignore = true)
  @Mapping(target = "followees", ignore = true)
  @Mapping(target = "roles", ignore = true)
  List<ListAllUsers> toUserListDTO(List<Users> users);
}
