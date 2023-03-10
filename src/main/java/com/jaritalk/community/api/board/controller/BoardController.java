package com.jaritalk.community.api.board.controller;

import com.jaritalk.community.api.board.dto.PostDetailDTO;
import com.jaritalk.community.api.board.dto.RegisterPostDTO;
import com.jaritalk.community.api.board.dto.UpdatePostDTO;
import com.jaritalk.community.api.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    /**
     * 커뮤니티 글 작성 API
     *
     * <pre>
     *     1. 임대인, 임차인, 공인중개사는 커뮤니티에 글 작성 가능
     *     2. 외부 사용자는 글 작성 불가
     * </pre>
     */
    @PostMapping
    public ResponseEntity<?> registerPost(
            @RequestBody @Valid RegisterPostDTO dto,
            @RequestAttribute("accountId") String accountId) {
        boardService.registerPost(dto, accountId);

        return ResponseEntity.ok().build();
    }

    /**
     * 커뮤니티 글 목록 조회 API
     *
     * <pre>
     *     1. 자리톡에 가입되어 있는 공인 중개사, 임대인, 임차인, 외부 사용자 모두 조회 가능
     *     2. 작성한 사용자가 어떤 계정 타입인지 표시(계정 타입은 한글로 표시) ex) 김씨(공인중개사)
     *     3. 글 목록에는 글에 달린 좋아요 수 표시
     *     4. 글 목록에 자신이 좋아요한 글인지 아닌지 표시
     * </pre>
     *
     * @return 커뮤니티 글 목록
     */
    @GetMapping
    public ResponseEntity<List<PostDetailDTO>> getPostList(
            @RequestHeader(required = false, value = HttpHeaders.AUTHORIZATION) String authorization) {
        List<PostDetailDTO> postList = boardService.getPostList(authorization);

        return ResponseEntity.ok(postList);
    }

    /**
     * 커뮤니티 글 수정 API
     *
     * <pre>
     *     1. 임대인, 임차인, 공인중개사는 커뮤니티글 수정 가능
     *     2. 외부 사용자는 글 수정 불가
     * </pre>
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(
            @PathVariable Long id,
            @RequestBody @Valid UpdatePostDTO dto,
            @RequestAttribute("accountId") String accountId) {
        boardService.updatePost(id, dto, accountId);

        return ResponseEntity.ok().build();
    }

    /**
     * 커뮤니티 글 삭제 API
     *
     * <pre>
     *     1. 임대인, 임차인, 공인중개사는 커뮤니티글 삭제 가능
     *     2. 외부 사용자는 글 삭제 불가
     * </pre>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(
            @PathVariable Long id,
            @RequestAttribute("accountId") String accountId) {
        boardService.deletePost(id, accountId);

        return ResponseEntity.ok().build();
    }

    /**
     * 커뮤니티 글 좋아요 API
     *
     * <pre>
     *     1. 좋아요는 한 계정이 한 글에 한 번만 가능
     *     2. 좋아요한 글에 한번 더 좋아요를 누르면 취소
     * </pre>
     */
    @PostMapping("/{id}/like")
    public ResponseEntity<?> likePost(
            @PathVariable Long id,
            @RequestAttribute("accountId") String accountId) {
        boardService.likePost(id, accountId);

        return ResponseEntity.ok().build();
    }
}
