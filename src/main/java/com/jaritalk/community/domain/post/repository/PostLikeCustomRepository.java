package com.jaritalk.community.domain.post.repository;

import com.jaritalk.community.domain.post.entity.PostLike;

import java.util.Optional;

public interface PostLikeCustomRepository {

    Optional<PostLike> exist(String accountId, Long postId);

    Long countByPostId(Long postId);

}
