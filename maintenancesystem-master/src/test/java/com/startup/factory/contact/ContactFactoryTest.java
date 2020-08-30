package com.startup.factory.contact;

import com.startup.entity.contact.Contact;
import com.startup.factory.contact.ContactFactory;
import org.junit.Test;

public class ContactFactoryTest {

    @Test
    public void createContact() {
        Contact contact = ContactFactory.createContact("0787859955", "shabied007@gmail.com", "0215523600");
        System.out.println(contact);
    }
}