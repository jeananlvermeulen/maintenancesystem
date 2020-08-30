package com.startup.repository.user.impl;

import com.startup.entity.user.Role;
import com.startup.factory.user.RoleFactory;
import com.startup.repository.user.RoleRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleRepositoryImplTest {

    private static RoleRepository repository =new RoleRepositoryImpl();
    private  Role role= RoleFactory.buildRole("RC74182","Electrician");

    @Test
    public void d_getAll() {
        System.out.println(repository.getAll());
    }

    @Test
    public void a_create() {
        Role created =repository.create(role);
        assertEquals(role.getRoleId(),created.getRoleId());
        System.out.println(("Create: " + created));
    }

    @Test
    public void b_update() {
        Role updated = new Role.Builder().copy(role).type("Elecrician").build();
     updated= repository.update(updated);
     System.out.println("Update: " + updated);
    }


    @Test
    public void e_delete() {
        repository.delete(role.getRoleId());
        

    }

    @Test
    public void c_read() {
        Role read= repository.read(role.getRoleId());
        System.out.println("Read::" + read);
    }
}