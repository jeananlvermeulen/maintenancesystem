package com.startup.service.contact;
import com.startup.entity.contact.Contact;
import com.startup.service.IService;

import java.util.Set;

public interface ContactService extends IService<Contact, String> {

    Set<Contact> getAll();
}
