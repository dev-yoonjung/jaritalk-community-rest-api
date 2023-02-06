package com.jaritalk.community.repository.user;

import com.jaritalk.community.entity.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Long, User> {

}
