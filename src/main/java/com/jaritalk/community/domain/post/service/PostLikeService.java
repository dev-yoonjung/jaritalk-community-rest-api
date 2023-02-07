package com.jaritalk.community.domain.post.service;

import com.jaritalk.community.domain.post.repository.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;

    public Long countByPostId(Long postId) {
        return postLikeRepository.countByPostId(postId);
    }

    public boolean exist(String accountId, Long postId) {
        return postLikeRepository.exist(accountId, postId).isPresent();
    }

}
