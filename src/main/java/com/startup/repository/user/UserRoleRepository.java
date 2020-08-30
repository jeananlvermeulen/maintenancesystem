package com.startup.repository.user;

import com.startup.entity.user.UserRole;
import com.startup.repository.IRepository;

import java.util.Set;

public interface UserRoleRepository extends IRepository<UserRole, String> {
    Set<UserRole> getAll();
}
