package com.startup.controller.contact;

import com.startup.entity.contact.Contact;
import com.startup.factory.contact.ContactFactory;
import com.startup.service.contact.impl.ContactServiceImpl;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactServiceImpl service;

    @PostMapping("/create")
    public Contact create(@RequestBody Contact contact){
        Contact newContact = ContactFactory.buildContact(contact.getPhone(),contact.getEmail(),contact.getHomephone());
        return service.create(newContact);
    }

    @GetMapping("/read/{id}")
    public Contact read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact){return service.update(contact);}

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){return service.delete(id);}

    @GetMapping("/all")
    public Set<Contact> getAll(){return service.getAll();}
}

