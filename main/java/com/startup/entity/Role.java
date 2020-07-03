package com.startup.entity;

import java.util.Objects;

public class Role {

    private String  roleId;
    private String type;


    public Role(){

    }
    private Role(Builder builder)
    {
        this.roleId = builder.roleId;
        this.type = builder.type;
    }

    public static class Builder{
        private String roleId;
        private String type;

        public Builder roleId(String role)
        {
            this.roleId = role;
            return this;
        }

        public Builder type(String type)
        {
            this.type = type;
            return this;
        }

        public Builder copy(Role role)
        {
            this.roleId = role.roleId;
            this.type = role.type;

            return this;
        }

        public Role build()
        {
            return new Role(this);
        }
    }

    public String getRoleId() {
        return roleId;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId.equals(role.roleId);
    }

    public int hashCode() {
        return Objects.hash(roleId);
    }
}
