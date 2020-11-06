package com.startup.service.contact.impl;
/**
 * @author @CloeteSC
 * Desc: Test Repository for Contact
 * Date: 27 October 2020
 */
import com.startup.entity.contact.Contact;
import com.startup.repository.contact.ContactRepository;
import com.startup.service.contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

//    private static ContactService service = null;
    @Autowired
    private ContactRepository repository;

    @Override
    public Set<Contact> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Contact create(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Contact update(Contact contact) {
        if (this.repository.existsById(contact.getPhone())){
            return this.repository.save(contact);
        }
        return null;

    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s)) return false;
        else return true;
    }
}
