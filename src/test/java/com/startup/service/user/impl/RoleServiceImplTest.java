package com.startup.service.user.impl;

import com.startup.entity.user.Role;
import com.startup.factory.user.RoleFactory;
import com.startup.repository.user.RoleRepository;
import com.startup.repository.user.impl.RoleRepositoryImpl;
import com.startup.service.user.RoleService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleServiceImplTest {

    private static RoleService roleService= RoleServiceImpl.getService();
    private Role role= RoleFactory.buildRole("RC74182","Electrician");

    @Test
    public void d_getAll() {
        System.out.println(roleService.getAll());
    }

    @Test
    public void a_create() {
        Role created =roleService.create(role);
        assertEquals(role.getRoleId(),created.getRoleId());
        System.out.println(("Create: " + created));
    }

    @Test
    public void b_read() {
        Role read= roleService.read(role.getRoleId());
        System.out.println("Read::" + read);
    }

    @Test
    public void c_update() {
        Role updated = new Role.Builder().copy(role).type("Elecrician").build();
        updated= roleService.update(updated);
        System.out.println("Update: " + updated);
    }

    @Test
    public void delete() {
        boolean deleted = roleService.delete(role.getRoleId());
        assertTrue(deleted);
        System.out.println("deleted :" + deleted);
    }
}