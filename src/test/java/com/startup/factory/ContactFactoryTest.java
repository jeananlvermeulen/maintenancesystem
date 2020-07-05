package com.startup.factory;

import com.startup.entity.Contact;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactFactoryTest {

    @Test
    public void createContact() {
        Contact contact = ContactFactory.createContact("0787859955", "shabied007@gmail.com", "0215523600");
        System.out.println(contact);
    }
}