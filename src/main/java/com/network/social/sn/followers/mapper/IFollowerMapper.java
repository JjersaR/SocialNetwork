package com.network.social.sn.followers.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.network.social.sn.followers.dto.Follow;
import com.network.social.sn.followers.entity.Followers;

@Mapper
public interface IFollowerMapper {

  IFollowerMapper INSTANCE = Mappers.getMapper(IFollowerMapper.class);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "followee.id", source = "followeeId")
  @Mapping(target = "follower.id", source = "followerId")
  Followers toEntity(Follow follow);
}
