package com.jaritalk.community.api.board.service;

import com.jaritalk.community.api.board.dto.PostDetailDTO;
import com.jaritalk.community.api.board.dto.RegisterPostDTO;
import com.jaritalk.community.api.board.dto.UpdatePostDTO;
import com.jaritalk.community.api.board.validator.PostValidator;
import com.jaritalk.community.domain.post.entity.Post;
import com.jaritalk.community.domain.post.service.PostLikeService;
import com.jaritalk.community.domain.post.service.PostService;
import com.jaritalk.community.domain.user.entity.User;
import com.jaritalk.community.domain.user.service.UserService;
import com.jaritalk.community.global.error.exception.AuthenticationException;
import com.jaritalk.community.global.error.exception.ErrorCode;
import com.jaritalk.community.global.error.exception.ForbiddenException;
import com.jaritalk.community.global.error.exception.NotValidParameterException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final UserService userService;

    private final PostService postService;

    private final PostLikeService postLikeService;

    private final PostValidator postValidator;

    @Transactional
    public void registerPost(RegisterPostDTO dto, String accountId) {
        User user = userService.findByAccountId(accountId);
        Post post = Post.of(dto.toEntity(), user);
        postService.save(post);
    }

    public List<PostDetailDTO> getPostList(String authorization) {
        String accountId = getAccountId(authorization);
        List<Post> postList = postService.findAll();
        return postList.stream()
                .map(p -> {
                    Long postId = p.getId();
                    Long likeCount = postLikeService.countByPostId(postId);
                    boolean likeYN = Optional.ofNullable(accountId)
                            .map(i -> postLikeService.exist(i, postId))
                            .orElse(false);

                    return PostDetailDTO.of(p, likeCount, likeYN);
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public void updatePost(Long id, UpdatePostDTO dto, String accountId) {
        if (!postValidator.validatePostId(id, dto)) {
            throw new NotValidParameterException(ErrorCode.NOT_VALID_POST_ID);
        }

        Post post = postService.findById(id);
        User user = userService.findByAccountId(accountId);

        if (!postValidator.validateAccessPost(post, user)) {
            throw new ForbiddenException(ErrorCode.FORBIDDEN_UPDATE_POST);
        }

        post.update(dto.toEntity());
    }

    @Transactional
    public void deletePost(Long id, String accountId) {
        Post post = postService.findById(id);
        User user = userService.findByAccountId(accountId);

        if (!postValidator.validateAccessPost(post, user)) {
            throw new ForbiddenException(ErrorCode.FORBIDDEN_DELETE_POST);
        }

        postService.deleteById(id);
    }

    private String getAccountId(String authorization) {
        if (!StringUtils.hasText(authorization)) {
            return null;
        }

        String[] authorizations = authorization.split(" ");
        if (authorizations.length < 2) {
            throw new AuthenticationException(ErrorCode.INVALID_AUTHENTICATION);
        }

        return authorizations[1];
    }
}
