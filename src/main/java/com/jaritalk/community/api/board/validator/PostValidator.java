package com.jaritalk.community.api.board.validator;

import com.jaritalk.community.api.board.dto.UpdatePostDTO;
import com.jaritalk.community.domain.post.entity.Post;
import com.jaritalk.community.domain.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PostValidator {

    public boolean validatePostId(Long postId, UpdatePostDTO dto) {
        return Objects.equals(postId, dto.getId());
    }

    public boolean validateAccessUpdatePost(Post post, User user) {
        return Objects.equals(post.getUser().getId(), user.getId());
    }

}
