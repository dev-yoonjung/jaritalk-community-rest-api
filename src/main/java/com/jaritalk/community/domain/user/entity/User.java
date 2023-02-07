package com.jaritalk.community.domain.user.entity;

import com.jaritalk.community.domain.user.constant.AccountType;
import com.jaritalk.community.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 8, unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 7)
    private AccountType accountType;

    @Column(nullable = false, length = 20, unique = true)
    private String accountId;

    @Column(nullable = false)
    private Boolean quit;

    @Column
    private LocalDateTime quitDate;
}
