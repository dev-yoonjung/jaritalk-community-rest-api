package com.jaritalk.community.entity.user;

import com.jaritalk.community.constant.AccountType;
import com.jaritalk.community.entity.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 8)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 7)
    private AccountType accountType;

    @Column(nullable = false, length = 20)
    private String accountId;

    @Column(nullable = false)
    private Boolean quit;

    private LocalDateTime quitedAt;
}
