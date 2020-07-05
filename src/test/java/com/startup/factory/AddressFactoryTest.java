package com.startup.factory;

import com.startup.entity.Address;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressFactoryTest {

    @Test
    public void buildAddress() {
        Address address = AddressFactory.buildAddress("14 briadale Eastgate", "PO BOX 66039 Estcourt");
        Assert.assertNotNull(address.getPhysicalAddress());
        System.out.println(address);
    }
}


