package com.startup.repository.contact;

import com.startup.entity.contact.Address;
import com.startup.repository.IRepository;

import java.util.Set;

public interface  AddressRepository extends IRepository<Address, String> {

    Set<Address> getAll();
}
