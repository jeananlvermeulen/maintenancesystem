package com.startup.service.technician.impl;

import com.startup.entity.technician.Profession;
import com.startup.factory.technician.ProfessionFactory;
import com.startup.service.technician.ProfessionService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfessionServiceImplTest {

     private static ProfessionService professionService = ProfessionServiceImpl.getService();
     private static Profession profession = ProfessionFactory.buildProfession("plumber","everything about pipe");


    @Test
    public void d_getAll() {
        Set<Profession> professions = professionService.getAll();
        assertEquals(1,professions.size());
        System.out.println("all professions: " +professions);
    }

    @Test
    public void a_create() {

        Profession created = professionService.create(profession);
        Assert.assertEquals(profession.getProfessionId(), created.getProfessionId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Profession read = professionService.read(profession.getProfessionId());
        System.out.println("Read: " +read);
    }

    @Test
    public void c_update() {
        Profession updated = new Profession.Builder()
                .copy(profession)
                .name("IT technician")
                .description("everything about IT")
                .build();
    }

    @Test
    public void e_delete() {
        boolean deleted = professionService.delete(profession.getProfessionId());
        Assert.assertFalse(deleted);
    }
}