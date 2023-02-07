package com.jaritalk.community.api.board.dto;

import com.jaritalk.community.domain.post.entity.Post;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UpdatePostDTO {

    @NotNull
    private Long id;

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
