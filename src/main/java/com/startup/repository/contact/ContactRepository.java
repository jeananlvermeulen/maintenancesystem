package com.startup.repository.contact;

import com.startup.entity.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

}
