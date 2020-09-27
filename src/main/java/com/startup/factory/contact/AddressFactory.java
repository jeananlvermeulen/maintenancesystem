/*
 AddressFactory class
 4/07/2020
 215285840
 */

package com.startup.factory.contact;

import com.startup.entity.contact.Address;
import static com.startup.util.Amr.generateId;

public class AddressFactory {

    public static Address buildAddress(String physicalAddress, String postalAddress){
        return new Address.Builder().addressId(generateId())
                .physicalAddress(physicalAddress)
                .postalAddress(postalAddress)
                .build();
    }
}
