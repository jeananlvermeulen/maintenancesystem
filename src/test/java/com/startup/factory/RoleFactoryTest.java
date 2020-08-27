package com.startup.factory;

import com.startup.entity.Role;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoleFactoryTest {

    @Test
    public void buildRole() {
        Role role = RoleFactory.buildRole("R", "Electrician");
        Assert.assertNotNull(role.getRoleId());
        System.out.println(role);

    }
}