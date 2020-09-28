package com.startup.entity.user;

import java.io.Serializable;

public class Role implements Serializable {
    
    private String  roleId;
    private String type;

    private Role(){}

    
    public Role (Builder builder){
        this.roleId = builder.roleId;
        this.type = builder.type;
    }


    public static class Builder{
        private String  roleId;
        private String type;
        
        public Builder roleId(String id){
            this.roleId = id;
            return this;
        }
        public Builder type(String type){
            this.type = type;
            return this;
        }

        public Builder copy(Role role){
            this.roleId= role.roleId;
            this.type = role.type;

            return this;
        }
        public Role build(){
            return new Role(this);
        }

        public Builder setType(String electrician) {
            return null;
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
}

