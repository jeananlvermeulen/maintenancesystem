package com.startup.controller.contact;

import com.startup.entity.contact.Address;
import com.startup.factory.contact.AddressFactory;
import com.startup.service.contact.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl service;

    @PostMapping("/create")
    public Address create(@RequestBody Address address){
        Address newAddress = AddressFactory.buildAddress(address.getPhysicalAddress(),address.getPostalAddress());
        return service.create(newAddress);
    }

    @GetMapping("/read/{id}")
    public Address read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/update")
    public Address update(@RequestBody Address address){return service.update(address);}

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){ return service.delete(id);}

    @GetMapping("/all")
    public Set<Address> getAll(){return service.getAll();}



}
