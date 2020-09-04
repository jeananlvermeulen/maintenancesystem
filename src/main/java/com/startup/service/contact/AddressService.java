package com.startup.service.contact;
import com.startup.entity.contact.Address;
import com.startup.service.IService;

import java.util.Set;

public interface AddressService extends IService<Address, String> {

    Set<Address> getAll();
}
