package com.jaritalk.community.entity.post;

import com.jaritalk.community.entity.base.BaseEntity;
import com.jaritalk.community.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "post_like")
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

}
