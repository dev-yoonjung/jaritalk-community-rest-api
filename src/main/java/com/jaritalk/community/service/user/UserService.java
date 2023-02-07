package com.jaritalk.community.service.user;

import com.jaritalk.community.entity.user.User;
import com.jaritalk.community.error.exception.EntityNotFoundException;
import com.jaritalk.community.error.exception.ErrorCode;
import com.jaritalk.community.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public User findByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.USER_NOT_EXISTS));
    }

    public boolean existsByAccountId(String accountId) {
        return userRepository.existsByAccountId(accountId);
    }

}
