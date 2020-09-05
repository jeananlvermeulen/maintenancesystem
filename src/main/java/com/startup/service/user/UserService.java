package com.startup.service.user;

import com.startup.entity.user.User;
import com.startup.service.IService;

import java.util.Set;

public interface UserService extends IService<User, String> {
    Set<User>getAll();
}
