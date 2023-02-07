package com.jaritalk.community.domain.post.service;

import com.jaritalk.community.domain.post.entity.PostLike;
import com.jaritalk.community.domain.post.repository.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;

    @Transactional
    public PostLike save(PostLike postLike) {
        return postLikeRepository.save(postLike);
    }

    public Long countByPostId(Long postId) {
        return postLikeRepository.countByPostId(postId);
    }

    public Optional<PostLike> exist(String accountId, Long postId) {
        return postLikeRepository.exist(accountId, postId);
    }

    @Transactional
    public void deleteById(Long id) {
        postLikeRepository.deleteById(id);
    }
}
