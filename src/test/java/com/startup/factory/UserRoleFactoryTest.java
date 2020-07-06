package com.startup.factory;

import com.startup.entity.UserRole;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author @VermeulenJL
 * Desc: Test for UserRoleFactory
 * Date: 05 July 2020
 */
public class UserRoleFactoryTest {

    @Test
    public void buildUserRole(){
        UserRole userRole = UserRoleFactory.buildUserRole("afsdsgsfdgf");
        Assert.assertNotNull(userRole.getUserId());
        System.out.println(userRole);
    }
}
