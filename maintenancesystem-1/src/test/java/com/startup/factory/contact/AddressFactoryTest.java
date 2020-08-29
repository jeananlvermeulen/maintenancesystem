package com.startup.factory.contact;

import com.startup.entity.contact.Address;
import com.startup.factory.contact.AddressFactory;
import org.junit.Assert;
import org.junit.Test;

public class AddressFactoryTest {

    @Test
    public void buildAddress() {
        Address address = AddressFactory.buildAddress("14 briadale Eastgate", "PO BOX 66039 Estcourt");
        Assert.assertNotNull(address.getPhysicalAddress());
        System.out.println(address);
    }
}


