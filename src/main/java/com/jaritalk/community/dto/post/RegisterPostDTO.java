package com.jaritalk.community.dto.post;

import com.jaritalk.community.entity.post.Post;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Setter
@ToString
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
