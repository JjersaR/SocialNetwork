package com.network.social.sn.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.network.social.sn.like.entity.Likes;

@Repository
public interface ILikesRepository extends JpaRepository<Likes, Long> {

}
