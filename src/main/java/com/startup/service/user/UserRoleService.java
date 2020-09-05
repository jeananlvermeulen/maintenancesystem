package com.startup.service.user;

import com.startup.entity.user.UserRole;
import com.startup.service.IService;

import java.util.Set;

public interface UserRoleService extends IService<UserRole, String> {
    Set<UserRole>getAll();
}
