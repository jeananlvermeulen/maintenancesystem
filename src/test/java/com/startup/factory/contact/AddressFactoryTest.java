package com.startup.factory.contact;

import com.startup.entity.contact.Address;
import org.junit.Assert;
import org.junit.Test;

public class AddressFactoryTest {

    @Test
    public void buildAddress() {
        Address address = AddressFactory.buildAddress("14 briadale Eastgate", "PO BOX 66039 Estcourt");
        System.out.println(address.getAddressId());
        Assert.assertNotNull(address.getAddressId());
        System.out.println(address);
    }
}


