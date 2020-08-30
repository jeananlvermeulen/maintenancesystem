package com.startup.repository.contact.impl;

import com.startup.entity.contact.Address;
import com.startup.factory.contact.AddressFactory;
import com.startup.repository.contact.AddressRepository;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressRepositoryImplTest {

    private static AddressRepository repository = AddressRepositoryImpl.getRepository();
    private static Address address = AddressFactory.buildAddress("10 Dorset Woodstock 8001", "PO Box 33069");

    @Test
    public void a_create() {
        Address created = repository.create(address);
        assertEquals(address.getPhysicalAddress(),created.getPhysicalAddress());
        System.out.println("create" + created);
    }

    @Test
    public void b_read() {
        Address read = repository.read(address.getPhysicalAddress());
        assertEquals(address.getPhysicalAddress(), read.getPhysicalAddress());
        System.out.println("reader" + read);
    }

    @Test
    public void c_update() {
        Address updated = new Address.Builder().copy(address).postalAddress("10 Dorset Woodstock 8001").build();
        updated = repository.update(updated);
        assertEquals(address.getPhysicalAddress(),updated.getPhysicalAddress());
        assertNotEquals(address.getPostalAddress(),updated.getPostalAddress());
        System.out.println("update: " + updated);

    }

    @Test
    //@Ignore
    public void d_delete() {
        boolean deleted = repository.delete(address.getPhysicalAddress());
        assertTrue(deleted);
        System.out.println("deleted :" + deleted);
    }

    @Test
    public void e_getAll() {
        Set<Address> addresses = repository.getAll();
        assertEquals(0,addresses.size());
        System.out.println(repository.getAll());
    }
}