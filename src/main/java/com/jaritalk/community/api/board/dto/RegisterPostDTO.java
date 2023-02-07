package com.jaritalk.community.api.board.dto;

import com.jaritalk.community.domain.post.entity.Post;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
public class RegisterPostDTO {

    @NotBlank
    private String title;

    private String content;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }

}
