package com.startup.factory.user;

import com.startup.entity.user.User;
import com.startup.factory.user.UserFactory;
import org.junit.Assert;
import org.junit.Test;

public class UserFactoryTest {

    @Test
    public void buildUser() {
        User user = UserFactory.buildUser("Golden", "Khumalo");
        Assert.assertNotNull(user.getUserId());
        System.out.println(user);
    }
}