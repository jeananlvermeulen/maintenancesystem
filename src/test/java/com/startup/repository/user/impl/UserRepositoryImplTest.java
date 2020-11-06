///*
//Golden Minenhle Ngwenya 215285840
// */
//package com.startup.repository.user.impl;
//
//
//import com.startup.entity.user.User;
//import com.startup.factory.user.UserFactory;
//import com.startup.repository.user.UserRepository;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class UserRepositoryImplTest {
//
//    private static UserRepository repository = UserRepositoryImpl.getRepository();
//    private static User user = UserFactory.buildUser("Minenhle","Khumalo");
//
//    @Test
//    public void a_create() {
//        User created = repository.create(user);
//        assertEquals(user.getUserId(),created.getUserId());
//        System.out.println("create" + created);
//    }
//
//    @Test
//    public void b_read() {
//        User read = repository.read(user.getUserId());
//        assertEquals(user.getUserId(),read.getUserId());
//        System.out.println("Read " + read);
//    }
//
//    @Test
//    public void c_update() {
//        User updated = new User.Builder().copy(user).lastname("Ngwenya").build();
//        updated = repository.update(updated);
//        assertEquals(user.getUserId(),updated.getUserId());
//        assertNotEquals(user.getLastname(),updated.getLastname());
//        System.out.println("update: " + updated);
//    }
//
//    @Test
//
//    public void e_delete() {
//        boolean deleted = repository.delete(user.getUserId());
//        assertTrue(deleted);
//        System.out.println("deleted :" + deleted);
//    }
//
//    @Test
//    public void d_getAll() {
//        Set<User> users = repository.getAll();
//        assertEquals(1,users.size());
//        System.out.println(repository.getAll());
//    }
//}