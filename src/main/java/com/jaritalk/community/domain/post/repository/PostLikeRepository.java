package com.jaritalk.community.domain.post.repository;

import com.jaritalk.community.domain.post.entity.PostLike;
import org.springframework.data.repository.CrudRepository;

public interface PostLikeRepository extends CrudRepository<PostLike, Long>, PostLikeCustomRepository {

}
