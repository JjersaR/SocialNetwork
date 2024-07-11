package com.network.social.sn.like.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.network.social.sn.like.dto.LikeSave;
import com.network.social.sn.like.entity.Likes;

@Mapper
public interface ILikeMapper {

  ILikeMapper INSTANCE = Mappers.getMapper(ILikeMapper.class);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "post.id", source = "postId")
  @Mapping(target = "user.id", source = "userId")
  Likes toEntity(LikeSave dto);
}
