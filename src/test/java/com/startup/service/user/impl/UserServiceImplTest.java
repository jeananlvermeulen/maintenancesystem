/*
Golden Minenhle Ngwenya 215285840
 */
package com.startup.service.user.impl;

import com.startup.entity.user.User;
import com.startup.factory.user.UserFactory;
import com.startup.service.user.UserService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {
    private static UserService service = UserServiceImpl.getService();
    private static User user = UserFactory.buildUser("Minenhle","Khumalo");

    @Test
    public void d_getAll() {
        Set<User> users = service.getAll();
        Assert.assertEquals(1,users.size());
        System.out.println(service.getAll());
    }

    @Test
    public void a_create() {
        User created = service.create(user);
        Assert.assertEquals(user.getUserId(),created.getUserId());
        System.out.println("create " + created);
    }

    @Test
    public void b_read() {
        User read = service.read(user.getUserId());
       Assert.assertEquals(user.getUserId(),read.getUserId());
        System.out.println("Read " + read);
    }

    @Test
    public void c_update() {
        User updated = new User.Builder().copy(user).lastname("Ngwenya").build();
        updated = service.update(updated);
        Assert.assertEquals(user.getUserId(),updated.getUserId());
       Assert.assertNotEquals(user.getLastname(),updated.getLastname());
        System.out.println("update: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(user.getUserId());
        Assert.assertTrue(deleted);
        System.out.println("deleted :" + deleted);
    }

}