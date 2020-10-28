//package com.startup.repository.contact.impl;
//
//
///**
// * @author @CloeteSC
// * Desc: Test Repository for Contact
// * Date: 30 August 2020
// */
//import com.startup.entity.contact.Contact;
//import com.startup.factory.contact.ContactFactory;
//import com.startup.repository.contact.ContactRepository;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.Assert.*;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//
//public class ContactRepositoryImplTest {
//
//    @Autowired
//    private  ContactRepository repository;
//    private static Contact contact = ContactFactory.createContact("0787894420","contact21@gmail.com","0215523215");
//
//    @Test
//    public void d_getAll() {
//        System.out.println("Get all: " + repository.findAll());
//    }
//
//    @Test
//    public void a_create() {
//        Contact created = repository.create(contact);
//        Assert.assertEquals(contact.getPhone(), created.getPhone());
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    public void c_update() {
//        Contact updated = new Contact.Builder().setPhone("0787894420").setEmail("contact23@gmail.com").setHomephone("0215523215").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete() {
//        boolean deleted = repository.delete(contact.getPhone());
//        Assert.assertTrue(deleted);
//    }
//
//    @Test
//    public void b_read() {
//        Contact read = repository.read(contact.getPhone());
//        System.out.println("Read: " + read);
//    }
//
//
//}