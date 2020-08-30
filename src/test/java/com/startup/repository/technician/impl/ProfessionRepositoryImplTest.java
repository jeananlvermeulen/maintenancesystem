package com.startup.repository.technician.impl;

import com.startup.entity.technician.Profession;
import com.startup.factory.technician.ProfessionFactory;
import com.startup.repository.technician.ProfessionRepository;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfessionRepositoryImplTest {

    private ProfessionRepository repository;
    private Profession profession;

    private Profession getSavedProfession() {
        Set<Profession> savedProfessions = this.repository.getAll();
        return savedProfessions.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ProfessionRepositoryImpl.getRepository();
        this.profession = ProfessionFactory.buildProfession("IT Technician","Everything about computer");
    }

    @Test
    public void d_getAll() {
        Set<Profession> all = this.repository.getAll();
        System.out.println("get all : " + all);
    }

    @Test
    public void a_create() {
        Profession created = this.repository.create(this.profession);
        System.out.println("In create, created : " + created);
        d_getAll();
        Assert.assertSame(created, this.profession);
    }

    @Test
    public void c_update() {
        String updatedName = "Plumber";
        String updatedDescription = "Cover all the plumbering";
        Profession profession = new Profession.Builder().copy(getSavedProfession())
                .name(updatedName).description(updatedDescription)
                .build();
        System.out.println("In update, about_to_update : " +profession);
        Profession updated = this.repository.update(profession);
        System.out.println("In update, updated : " + updated);
        Assert.assertSame(updatedName, updated.getName());
        Assert.assertSame(updatedDescription, updated.getDescription());
        d_getAll();
    }


    @Test
    public void e_delete() {
        boolean deleted = repository.delete(profession.getProfessionId());
        assertFalse(deleted);
        System.out.println("deleted :" + deleted);
    }

    @Test
    public void b_read() {
        Profession savedProfession = getSavedProfession();
        System.out.println("In read, courseId : "+ savedProfession.getProfessionId());
        Profession read = this.repository.read(savedProfession.getProfessionId());
        System.out.println("In read, read : " + read);
        d_getAll();
        Assert.assertEquals(savedProfession, read);
    }
}