/*
 Address class
 2/07/2020
 215285840
 */

package com.startup.entity.contact;

import java.util.Objects;

public class Address {

    private String physicalAddress;
    private String postalAddress;

    public Address() {
    }

    private Address(Builder builder) {
        this.physicalAddress = builder.physicalAddress;
        this.postalAddress = builder.postalAddress;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public static class Builder{

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

        public Builder copy(Address address){
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
                "physicalAddress='" + physicalAddress + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return physicalAddress.equals(address.physicalAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(physicalAddress);
    }
}
