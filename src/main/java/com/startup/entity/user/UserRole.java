package com.startup.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author @VermeulenJL
 * Desc: Entity for UserRole
 * Date: 04 July 2020
 */

@Entity
@IdClass(UserRoleId.class)
public class UserRole implements Serializable{

    @Id
    private String userId, roleId;

    public UserRole(){

    }


    private UserRole(Builder builder){

        this.userId = builder.userId;
        this.roleId = builder.roleId;
    }

    public String getUserId() { return userId; }
    public String getRoleId() { return roleId; }

    public static class Builder{

        private String userId;
        private String roleId;

        public Builder userId(String userId){
            this.userId = userId;
            return this;
        }

        public Builder roleId(String roleId){
            this.roleId = roleId;
            return this;
        }


        public Builder copy(UserRole userrole){

            this.userId = userrole.userId;
            this.roleId = userrole.roleId;
            return this;
        }

        public UserRole build() { return new UserRole( this); }

    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId='" + userId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }


}
