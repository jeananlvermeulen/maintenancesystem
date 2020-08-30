package com.startup.factory.user;

import com.startup.entity.user.Role;

public class RoleFactory {
    public static Role buildRole(String roleId, String type){
        return new Role.Builder()
                .roleId(roleId)
                .type(type)
                .build();
    }
}
