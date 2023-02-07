package com.jaritalk.community.global.error.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // 인증
    INVALID_AUTHENTICATION(400, "잘못된 Authentication 입니다."),
    NOT_EXISTS_AUTHENTICATION(401, "Authentication Header가 빈 값입니다."),

    // 커뮤니티
    FORBIDDEN_ROLE(403, "커뮤니티 작성/수정/삭제 권한이 없습니다."),
    NOT_VALID_POST_ID(401, "잘못된 글 수정 요청입니다."),
    POST_NOT_EXISTS(400, "해당 글은 존재하지 않습니다."),
    FORBIDDEN_UPDATE_POST(403, "해당 글에 대해 수정 권한이 없습니다."),
    FORBIDDEN_DELETE_POST(403, "해당 글에 대해 삭제 권한이 없습니다."),

    // 회원
    USER_NOT_EXISTS(400, "해당 회원은 존재하지 않습니다.");

    private int status;

    private String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
