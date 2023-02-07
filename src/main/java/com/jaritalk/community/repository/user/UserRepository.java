package com.jaritalk.community.repository.user;

import com.jaritalk.community.entity.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);

    @Query(value = "select count(u.user_id) > 0 from user u where u.account_id = :accountId and u.quit = false limit 1", nativeQuery = true)
    boolean existsByAccountId(String accountId);

}
