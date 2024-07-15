package com.network.social.sn.post.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.network.social.sn.comments.entity.Comments;
import com.network.social.sn.post.dto.IPostById;
import com.network.social.sn.post.dto.ListPostComments;
import com.network.social.sn.post.dto.PostSave;
import com.network.social.sn.post.entity.Post;
import com.network.social.sn.user.entity.Users;

@Mapper
public interface IPostMapper {

  IPostMapper INSTANCE = Mappers.getMapper(IPostMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "userUsername", source = "user.username")
  @Mapping(target = "comments", source = "comments")
  IPostById toPostDTO(Post post);

  @Mapping(target = "commentId", source = "id")
  @Mapping(target = "username", source = "user.username")
  @Mapping(target = "postId", source = "post.id")
  @Mapping(target = "comments", source = "content")
  ListPostComments toCommentsDTO(Comments comment);

  List<ListPostComments> toCommentsDTO(List<Comments> comments);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "user", source = "userId")
  @Mapping(target = "comments", ignore = true)
  @Mapping(target = "likes", ignore = true)
  Post toEntity(PostSave postSave);

  @Mapping(target = "id", source = "userId")
  Users toUserEntity(Long userId);
}
