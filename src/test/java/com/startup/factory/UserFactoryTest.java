package com.startup.factory;

import com.startup.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserFactoryTest {

    @Test
    public void buildUser() {
        User user = UserFactory.buildUser("Golden", "Khumalo");
        Assert.assertNotNull(user.getUserId());
        System.out.println(user);
    }
}