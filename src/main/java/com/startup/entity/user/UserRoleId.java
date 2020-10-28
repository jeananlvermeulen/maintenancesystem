package com.startup.entity.user;

import java.io.Serializable;
import java.util.Objects;

public class UserRoleId implements Serializable {

    private String userId, roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleId that = (UserRoleId) o;
        return userId.equals(that.userId) &&
                roleId.equals(that.roleId);
    }

    @Override
    public int hashCode() { return Objects.hash(roleId, userId); }
}
