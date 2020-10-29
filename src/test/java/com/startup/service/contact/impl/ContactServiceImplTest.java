package com.startup.service.contact.impl;
/**
 * @author @CloeteSC
 * Desc: Test Repository for Contact
 * Date: 28 October 2020
 */
import com.startup.entity.contact.Contact;
import com.startup.factory.contact.ContactFactory;
import com.startup.service.contact.ContactService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactServiceImplTest {

    @Autowired
    private static ContactService service;
    private static Contact contact = ContactFactory.createContact("0787894420","contact21@gmail.com","0215523215");


    @Test
    public void d_getAll() {
        Set<Contact> contacts = service.getAll();
        assertEquals(1, contacts.size());
        System.out.println("All contacts: " + contacts);
    }

    @Test
    public void a_create() {
        Contact created = service.create(contact);
        Assert.assertEquals(contact.getPhone(), created.getPhone());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Contact read = service.read(contact.getPhone());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Contact updated = new Contact.Builder().setPhone("0787894420").setEmail("contact23@gmail.com").setHomephone("0215523215").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(contact.getPhone());
        Assert.assertTrue(deleted);
    }
}