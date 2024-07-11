package com.network.social.sn.comments.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.network.social.sn.comments.dto.CommentSave;
import com.network.social.sn.comments.entity.Comments;

@Mapper
public interface ICommentsMapper {

  ICommentsMapper INSTANCE = Mappers.getMapper(ICommentsMapper.class);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "post.id", source = "postId")
  @Mapping(target = "user.id", source = "userId")
  Comments toEntity(CommentSave comment);
}
