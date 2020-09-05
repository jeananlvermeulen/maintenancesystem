package com.startup.service.contact.impl;

import com.startup.entity.contact.Address;
import com.startup.repository.contact.AddressRepository;
import com.startup.repository.contact.impl.AddressRepositoryImpl;
import com.startup.service.contact.AddressService;

import java.util.HashSet;
import java.util.Set;

public class AddressServiceImpl implements AddressService {


    private static AddressService service = null;
    private AddressRepository repository;

    private AddressServiceImpl(){
        this.repository = AddressRepositoryImpl.getRepository();
    }

    public static AddressService getService(){
        if(service == null)
            service = new AddressServiceImpl();
        return service;
    }


    @Override
    public Address create(Address address) {
        return this.repository.create(address);
    }

    @Override
    public Address read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Address update(Address address) {
        return this.repository.update(address);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public Set<Address> getAll() {
        return this.repository.getAll();
    }
}
