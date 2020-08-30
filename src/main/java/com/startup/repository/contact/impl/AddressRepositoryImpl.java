/*
Golden Minenhle Ngwenya 215285840
 */

package com.startup.repository.contact.impl;

import com.startup.entity.contact.Address;
import com.startup.repository.contact.AddressRepository;

import java.util.HashSet;
import java.util.Set;

public class AddressRepositoryImpl implements AddressRepository {

    private static AddressRepository repository = null;
    private Set<Address> addressDB;

    private AddressRepositoryImpl(){
        this.addressDB = new HashSet<>();
    }

    public static AddressRepository getRepository(){
        if(repository == null)
            repository = new AddressRepositoryImpl();
        return repository;
    }

    @Override
    public Address create(Address address) {
        this.addressDB.add(address);
        return address;
    }

    @Override
    public Address read(String s) {
        for(Address address: this.addressDB){
            if(address.getPhysicalAddress().equalsIgnoreCase(s))return address;
        }
        return null;
    }

    @Override
    public Address update(Address address) {
        boolean deleteAddress = delete(address.getPhysicalAddress());
        if(deleteAddress){
            this.addressDB.add(address);
            return address;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Address address = read(s);
        if(address != null){
            this.addressDB.remove(address);
            return true;
        }
        return false;
    }

    @Override
    public Set<Address> getAll() {
        return this.addressDB;
    }
}
