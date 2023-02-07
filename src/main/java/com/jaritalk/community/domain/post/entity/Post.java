package com.jaritalk.community.domain.post.entity;

import com.jaritalk.community.domain.user.entity.User;
import com.jaritalk.community.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
