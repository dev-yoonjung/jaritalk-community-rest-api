package com.jaritalk.community.service.post;

import com.jaritalk.community.dto.post.RegisterPostDTO;
import com.jaritalk.community.entity.post.Post;
import com.jaritalk.community.entity.user.User;
import com.jaritalk.community.repository.post.PostRepository;
import com.jaritalk.community.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final UserService userService;

    private final PostRepository postRepository;

    @Transactional
    public void registerPost(RegisterPostDTO dto, String accountId) {
        User user = userService.findByAccountId(accountId);
        log.info("writer: {}", user);
        Post post = Post.of(dto.toEntity(), user);
        postRepository.save(post);
    }

}
