package com.jaritalk.community.domain.post.repository;

import com.jaritalk.community.domain.post.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("select p from Post p join fetch p.user")
    List<Post> findAll();

}
