package com.jaritalk.community.api.board.dto;

import com.jaritalk.community.domain.post.entity.Post;
import com.jaritalk.community.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class PostDetailDTO {

    private Long id;

    private String title;

    private String content;

    private String writer;

    private Long likeCount;

    private boolean likeYN;

    private LocalDateTime createTime;

    public static PostDetailDTO of(Post post, Long likeCount, boolean likeYN) {
        User writer = post.getUser();
        String nickname = writer.getNickname();
        String accountType = writer.getAccountType()
                .getName();

        return PostDetailDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .writer(String.format("%s(%s)", nickname, accountType))
                .likeCount(likeCount)
                .likeYN(likeYN)
                .createTime(post.getCreateTime())
                .build();
    }

}
