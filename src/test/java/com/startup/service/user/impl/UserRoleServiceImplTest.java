package com.startup.service.user.impl;
/* Jeanan Vermeulen
   215002725
*/
import com.startup.entity.user.UserRole;
import com.startup.factory.user.UserRoleFactory;
import com.startup.service.user.UserRoleService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UserRoleServiceImplTest {

    private static UserRoleService userRoleService = UserRoleServiceImpl.getService();
    private UserRole userRole = UserRoleFactory.buildUserRole("215002725");

    @Test
    public void getAll() {
        System.out.println(userRoleService.getAll());
    }

    @Test
    public void create() {
        UserRole created = userRoleService.create(userRole);
        assertEquals(userRole.getUserId(),created.getUserId());
        System.out.println(("Create: " + created));
    }

    @Test
    public void read() {
        UserRole read = userRoleService.read(userRole.getUserId());
        System.out.println("Read:" + read);
    }

    @Test
    public void update() {
        UserRole updated = new UserRole.Builder().copy(userRole).build();
        updated= userRoleService.update(updated);
        System.out.println("Update: " + updated);
    }

    @Test
    public void delete() {
        boolean deleted = userRoleService.delete(userRole.getUserId());
        assertTrue(deleted);
        System.out.println("deleted: " + deleted);

    }
}