package com.jaritalk.community.domain.post.service;

import com.jaritalk.community.domain.post.entity.Post;
import com.jaritalk.community.domain.post.repository.PostRepository;
import com.jaritalk.community.domain.user.service.UserService;
import com.jaritalk.community.global.error.exception.EntityNotFoundException;
import com.jaritalk.community.global.error.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final UserService userService;

    private final PostLikeService postLikeService;

    private final PostRepository postRepository;

    @Transactional
    public Post save(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.POST_NOT_EXISTS));
    }

}
