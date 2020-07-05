package com.startup.factory;

import com.startup.entity.Contact;

/**
 * @author @CloeteSC
 * Desc: Factory for Contact
 * Date: 05 July 2020
 */
public class ContactFactory {

    public static Contact createContact(String phone, String email, String homephone){
        Contact contact = new Contact.Builder()
                .setPhone(phone)
                .setEmail(email)
                .setHomephone(homephone)
                .build();
        return contact;
    }

}
