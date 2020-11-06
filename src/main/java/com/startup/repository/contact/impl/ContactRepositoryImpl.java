//package com.startup.repository.contact.impl;
//
//
///**
// * @author @CloeteSC
// * Desc: Repository for Contact
// * Date: 30 August 2020
// */
//
//import com.startup.entity.contact.Contact;
//import com.startup.repository.contact.ContactRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//public class ContactRepositoryImpl implements ContactRepository {
//
//    private static ContactRepository repository = null;
//    private Set<Contact> contactDB;
//
//    private ContactRepositoryImpl(){ this.contactDB = new HashSet<>();
//    }
//
//    public static ContactRepository getRepository(){
//        if (repository == null) repository = new ContactRepositoryImpl();
//        return repository;
//    }
//    @Override
//    public Set<Contact> getAll() {
//        return this.contactDB;
//
//    }
//
//    @Override
//    public Contact create(Contact contact) {
//
//        this.contactDB.add(contact);
//        return contact;
//    }
//
//    @Override
//    public Contact update(Contact contact) {
//
//        boolean deleteContact = delete(contact.getPhone());
//        if (deleteContact){
//            this.contactDB.add(contact);
//            return contact;
//        }
//
//        return null;
//    }
//
//    @Override
//    public boolean delete(String phone) {
//        Contact contact = read(phone);
//        if (contact != null){
//            this.contactDB.remove(contact);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Contact read(String phone) {
//        for(Contact contact: this.contactDB){
//            if(contact.getPhone().equalsIgnoreCase(phone)) return contact;
//        }
//        return null;
//    }
//}
