package com.startup.service.contact.impl;

import com.startup.entity.contact.Address;
import com.startup.repository.contact.AddressRepository;
import com.startup.service.contact.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {


    @Autowired
    private AddressRepository repository;


    @Override
    public Address create(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Address read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Address update(Address address) {
        if (this.repository.existsById(address.getAddressId())){
            return this.repository.save(address);
        }
        return null;

    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s)) return false;
        else return true;
    }

    @Override
    public Set<Address> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfActiveAddresses() {
        return this.repository.findAll().stream().collect(Collectors.toSet()).size();
    }

}
