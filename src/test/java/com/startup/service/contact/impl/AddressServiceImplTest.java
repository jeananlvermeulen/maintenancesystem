/*
Golden Minenhle Ngwenya 215285840
 */
package com.startup.service.contact.impl;

import com.startup.entity.contact.Address;
import com.startup.factory.contact.AddressFactory;
import com.startup.service.contact.AddressService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressServiceImplTest {
    @Autowired
    private AddressService service;
    private static Address address = AddressFactory.buildAddress("10 Dorset Woodstock 8001", "PO Box 33069");


    @Test
    public void d_getAll() {
        Set<Address> addresses = service.getAll();
        assertEquals(1,addresses.size());
        System.out.println(service.getAll());
    }

    @Test
    public void a_create() {
        Address created = service.create(address);
        assertEquals(address.getAddressId(),created.getAddressId());
        System.out.println("create " + created);
    }

    @Test
    public void b_read() {
        Address read = service.read(address.getAddressId());
        assertEquals(address.getAddressId(), read.getAddressId());
        System.out.println("reader " + read);
    }

    @Test
    public void c_update() {
        Address updated = new Address.Builder().copy(address).postalAddress("10 Dorset Woodstock 8001").build();
        updated = service.update(updated);
        assertEquals(address.getAddressId(),updated.getAddressId());
        assertNotEquals(address.getPostalAddress(),updated.getPostalAddress());
        System.out.println("update: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(address.getAddressId());
        assertTrue(deleted);
        System.out.println("deleted :" + deleted);
    }

}