package com.startup.factory;

import com.startup.entity.UserRole;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRoleFactoryTest {

    @Test
    public void buildUserRole(){
        UserRole userRole = UserRoleFactory.buildUserRole("afsdsgsfdgf");
        Assert.assertNotNull(userRole.getUserId());
        System.out.println(userRole);
    }
}
