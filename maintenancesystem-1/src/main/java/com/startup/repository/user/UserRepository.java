package com.startup.repository.user;

import com.startup.entity.user.User;
import com.startup.repository.IRepository;

import java.util.Set;

public interface UserRepository extends IRepository<User, String> {
    Set<User> getAll();
}
