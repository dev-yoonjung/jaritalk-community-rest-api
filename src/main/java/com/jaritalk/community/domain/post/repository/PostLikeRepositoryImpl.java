package com.jaritalk.community.domain.post.repository;

import com.jaritalk.community.domain.post.entity.PostLike;
import com.jaritalk.community.domain.post.entity.QPostLike;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostLikeRepositoryImpl implements PostLikeCustomRepository {

    private final JPQLQueryFactory queryFactory;

    @Override
    public Optional<PostLike> exist(String accountId, Long postId) {
        QPostLike postLike = QPostLike.postLike;

        PostLike like = queryFactory
                .selectFrom(postLike)
                .where(
                        postLike.user.accountId.eq(accountId),
                        postLike.post.id.eq(postId))
                .fetchFirst();

        return Optional.ofNullable(like);
    }

    @Override
    public Long countByPostId(Long postId) {
        QPostLike postLike = QPostLike.postLike;

        return queryFactory
                .selectFrom(postLike)
                .where(postLike.post.id.eq(postId))
                .fetchCount();
    }

}
