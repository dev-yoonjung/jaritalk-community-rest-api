package com.jaritalk.community.repository.post;

import com.jaritalk.community.entity.post.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
