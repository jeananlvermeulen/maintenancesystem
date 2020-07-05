package com.startup.factory;

import com.startup.entity.UserRole;

import static com.startup.util.Amr.generateId;

public class UserRoleFactory {
    public static UserRole buildUserRole(String roleId){
        return new UserRole.Builder().userId(generateId())
                .roleId(roleId)
                .build();
    }
}
