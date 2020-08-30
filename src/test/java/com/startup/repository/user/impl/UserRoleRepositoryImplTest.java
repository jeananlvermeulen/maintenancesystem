///*
//Jeanan Vermeulen
//215002725
//*/
//package com.startup.repository.user.impl;
//
//import com.startup.entity.user.UserRole;
//import com.startup.factory.user.UserRoleFactory;
//import com.startup.repository.user.UserRoleRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class UserRoleRepositoryImplTest {
//
//    private UserRoleRepository repository;
//    private UserRole userRole;
//
//    private UserRole getSavedUserRole(){
//        Set<UserRole> savedUserRoles = this.repository.getAll();
//        return savedUserRoles.iterator().next();
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        this.repository = UserRoleRepositoryImpl.getRepository();
//        this.userRole = UserRoleFactory.buildUserRole("215002725","Full Stack Developer");
//    }
//
//    @Test
//    public void d_getAll() {
//        Set<UserRole> all = this.repository.getAll();
//        System.out.println("In getAll, all = " + all);
//    }
//
//    @Test
//    public void a_create() {
//        UserRole created = this.repository.create(this.userRole);
//        System.out.println("In Create, Created : " +created);
//        d_getAll();
//        Assert.assertSame(created, this.userRole);
//    }
//
//    @Test
//    public void c_update() {
//        String newUserId = "the new userId";
//        String newRoleId = "the new roleId";
//        UserRole userRole = new UserRole.Builder()
//                .copy(getSavedUserRole()).userId(newUserId)
//                .roleId(newRoleId).build();
//        System.out.println("In update, about_to_updated = " + userRole);
//        UserRole updated = this.repository.update(userRole);
//        System.out.println("In update, updated = " + updated);
//        Assert.assertSame(newUserId, updated.getUserId());
//        Assert.assertSame(newRoleId, updated.getRoleId());
//        d_getAll();
//    }
//
//    @Test
//    public void e_delete() {
//        UserRole savedUserRole = getSavedUserRole();
//        this.repository.delete(savedUserRole.getUserId().getroleId());
//        d_getAll();
//    }
//
//    @Test
//    public void b_read() {
//        UserRole savedUserRole = getSavedUserRole();
//        System.out.println("In read, userId + roleId: " + savedUserRole.getUserId().getroleId());
//        UserRole read = this.repository.read(savedUserRole.getUserId().getroleId());
//        System.out.println("In read, read = " + read);
//        d_getAll();
//        Assert.assertEquals(savedUserRole, read);
//    }
//}