/*
 Address class
 2/07/2020
 215285840
 */

package com.startup.entity.contact;

import java.util.Objects;

public class Address {

    private String addressId;
    private String physicalAddress;
    private String postalAddress;

    public Address() {
    }

    private Address(Builder builder) {
        this.addressId = builder.addressId;
        this.physicalAddress = builder.physicalAddress;
        this.postalAddress = builder.postalAddress;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public String getAddressId(){
        return addressId;
    }

    public static class Builder{

        private String addressId;
        private String physicalAddress;
        private String postalAddress;

        public Builder physicalAddress(String physicalAddress) {
            this.physicalAddress = physicalAddress;
            return this;
        }
        public Builder postalAddress(String postalAddress) {
            this.postalAddress = postalAddress;
            return this;
        }
        public Builder addressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder copy(Address address){
            this.addressId = address.addressId;
            this.physicalAddress = address.physicalAddress;
            this.postalAddress = address.postalAddress;

            return this;
        }

        public Address build() {
            return new Address(this);
        }

    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +"physicalAddress='" + physicalAddress + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId.equals(address.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId);
    }
}
