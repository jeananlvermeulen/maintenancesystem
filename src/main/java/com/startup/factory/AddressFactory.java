package com.startup.factory;

import com.startup.entity.Address;

public class AddressFactory {

    public static Address buildAddress(String physicalAddress, String postalAddress){

        return new Address.Builder()
                .physicalAddress(physicalAddress)
                .postalAddress(postalAddress)
                .build();
    }
}
