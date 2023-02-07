package com.jaritalk.community.domain.post.repository;

import com.jaritalk.community.domain.post.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("select p from Post p join fetch p.user")
    List<Post> findAll();

    @Query("select p from Post p join fetch p.user where p.id = :id")
    Optional<Post> findById(Long id);
}
