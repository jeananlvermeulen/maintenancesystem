package com.startup.factory.user;

import com.startup.entity.user.Role;
import com.startup.factory.user.RoleFactory;
import org.junit.Assert;
import org.junit.Test;

public class RoleFactoryTest {

    @Test
    public void buildRole() {
        Role role = RoleFactory.buildRole("R", "Electrician");
        Assert.assertNotNull(role.getRoleId());
        System.out.println(role);

    }
}