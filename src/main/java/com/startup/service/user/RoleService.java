package com.startup.service.user;

import com.startup.entity.technician.Maintenance;
import com.startup.entity.user.Role;
import com.startup.service.IService;

import java.util.Set;

public interface RoleService extends IService<Role, String> {
    Set<Role>getAll();
}
