package com.startup.factory.user;

import com.startup.entity.user.UserRole;
import com.startup.factory.user.UserRoleFactory;
import org.junit.Assert;
import org.junit.Test;

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
