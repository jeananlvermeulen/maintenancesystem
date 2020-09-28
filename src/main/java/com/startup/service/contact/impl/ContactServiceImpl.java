package com.startup.service.contact.impl;
/**
 * @author @CloeteSC
 * Desc: Test Repository for Contact
 * Date: 05 September 2020
 */
import com.startup.entity.contact.Contact;
import com.startup.repository.contact.ContactRepository;
import com.startup.repository.contact.impl.ContactRepositoryImpl;
import com.startup.service.contact.ContactService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ContactServiceImpl implements ContactService {

    private static ContactService service = null;
    private ContactRepository repository;

    private ContactServiceImpl(){
        this.repository = ContactRepositoryImpl.getRepository();
    }

    public static ContactService getService(){
        if (service == null) service = new ContactServiceImpl();
        return service;
    }

    @Override
    public Set<Contact> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Contact create(Contact contact) {
        return this.repository.create(contact);
    }

    @Override
    public Contact read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Contact update(Contact contact) {
        return this.repository.update(contact);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
