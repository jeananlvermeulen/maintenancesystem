package com.startup.repository.contact;

import com.startup.entity.contact.Contact;
import com.startup.repository.IRepository;

import java.util.Set;

public interface ContactRepository extends IRepository<Contact, String> {

    Set<Contact> getAll();
}
