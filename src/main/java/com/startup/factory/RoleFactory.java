package com.startup.factory;

import com.startup.entity.Role;

public class RoleFactory {
    public static Role buildRole(String roleId, String type){
        return new Role.Builder()
                .roleId(roleId)
                .type(type)
                .build();
    }
}
