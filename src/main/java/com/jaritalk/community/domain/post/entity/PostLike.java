package com.jaritalk.community.domain.post.entity;

import com.jaritalk.community.domain.base.BaseEntity;
import com.jaritalk.community.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@Entity
@Table(name = "post_like")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostLike extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_like_id")
    private Long id;
    
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;

    public static PostLike of(User user, Post post) {
        return PostLike.builder()
                .user(user)
                .post(post)
                .build();
    }

}
