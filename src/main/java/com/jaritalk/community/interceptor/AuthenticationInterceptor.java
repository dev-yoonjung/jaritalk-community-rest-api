package com.jaritalk.community.interceptor;

import com.jaritalk.community.constant.AccountType;
import com.jaritalk.community.error.exception.AuthenticationException;
import com.jaritalk.community.error.exception.EntityNotFoundException;
import com.jaritalk.community.error.exception.ErrorCode;
import com.jaritalk.community.error.exception.ForbiddenException;
import com.jaritalk.community.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {

    private final UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (method.equals(HttpMethod.GET.name())) {
            return true;
        }

        if (!StringUtils.hasText(authorizationHeader)) {
            throw new AuthenticationException(ErrorCode.NOT_EXISTS_AUTHENTICATION);
        }

        String[] authorizations = authorizationHeader.split(" ");
        if (authorizations.length < 2) {
            throw new AuthenticationException(ErrorCode.INVALID_AUTHENTICATION);
        }

        if (!AccountType.isAccountType(authorizations[0])) {
            throw new ForbiddenException(ErrorCode.FORBIDDEN_ROLE);
        }

        if (!userService.existsByAccountId(authorizations[1])) {
            throw new EntityNotFoundException(ErrorCode.USER_NOT_EXISTS);
        }

        request.setAttribute("accountId", authorizations[1]);

        return true;
    }
}
