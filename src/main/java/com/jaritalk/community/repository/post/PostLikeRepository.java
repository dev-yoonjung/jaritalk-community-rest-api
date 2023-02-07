package com.jaritalk.community.repository.post;

import com.jaritalk.community.entity.post.PostLike;
import org.springframework.data.repository.CrudRepository;

public interface PostLikeRepository extends CrudRepository<PostLike, Long> {
}
