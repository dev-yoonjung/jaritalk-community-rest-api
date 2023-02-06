package com.jaritalk.community.constant;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum AccountType {

    LESSOR("임차인"),
    REALTOR("공인중개사"),
    LESSEE("임차인");

    private final String name;

    AccountType(String name) {
        this.name = name;
    }

    /**
     * 해당 문자열이 AccountType에 해당하는지 검증하는 메서드
     * @param type 계정 타입 문자열
     * @return AccountType 해당 유무
     */
    public static boolean isAccountType(String type) {
        List<AccountType> collect = Arrays.stream(AccountType.values())
                .filter(t -> t.name().equals(type))
                .collect(Collectors.toList());

        return collect.size() > 0;
    }

}
