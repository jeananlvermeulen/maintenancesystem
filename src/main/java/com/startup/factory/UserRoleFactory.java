package com.startup.factory;

import com.startup.entity.UserRole;

import static com.startup.util.Amr.generateId;

/**
 * @author @VermeulenJL
 * Desc: Factory for UserRole
 * Date: 05 July 2020
 */

public class UserRoleFactory {
    public static UserRole buildUserRole(String roleId){
        return new UserRole.Builder().userId(generateId())
                .roleId(roleId)
                .build();
    }
}
