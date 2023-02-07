package com.jaritalk.community.entity.post;

import com.jaritalk.community.entity.user.User;
import com.jaritalk.community.entity.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Builder
@Entity
@Table(name = "post")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    private String content;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public static Post of(Post post, User user) {
        return Post.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .user(user)
                .build();
    }

}
