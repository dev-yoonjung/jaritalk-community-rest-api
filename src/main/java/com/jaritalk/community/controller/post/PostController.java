package com.jaritalk.community.controller.post;

import com.jaritalk.community.dto.post.RegisterPostDTO;
import com.jaritalk.community.service.post.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    /**
     * 커뮤니티 글 작성 API
     *
     * <p>
     *     1. 임대인, 임차인, 공인중개사는 커뮤니티에 글 작성 가능
     *     2. 외부 사용자는 글 작성 불가
     * </p>
     */
    @PostMapping
    public ResponseEntity<?> registerPost(
            @RequestBody @Valid RegisterPostDTO dto,
            @RequestAttribute("accountId") String accountId) {
        log.info("post: {}", dto);
        log.info("account id: {}", accountId);
        postService.registerPost(dto, accountId);

        return ResponseEntity.ok().build();
    }

    /**
     * 커뮤니티 글 목록 조회 API
     *
     * <p>
     *     1. 자리톡에 가입되어 있는 공인 중개사, 임대인, 임차인, 외부 사용자 모두 조회 가능
     *     2. 작성한 사용자가 어떤 계정 타입인지 표시(계정 타입은 한글로 표시) ex) 김씨(공인중개사)
     *     3. 글 목록에는 글에 달린 좋아요 수 표시
     *     4. 글 목록에 자신이 좋아요한 글인지 아닌지 표시
     * </p>
     *
     * @return 커뮤니티 글 목록
     */

}
