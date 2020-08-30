package com.startup.repository.user;

import com.startup.entity.user.Role;
import com.startup.repository.IRepository;

import java.util.Set;

public interface RoleRepository extends IRepository<Role, String> {
    Set<Role> getAll();
}
