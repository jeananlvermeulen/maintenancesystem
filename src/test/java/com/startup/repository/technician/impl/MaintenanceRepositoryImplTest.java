package com.startup.repository.technician.impl;
import com.startup.entity.technician.Maintenance;
import com.startup.factory.technician.MaintenanceFactory;
import com.startup.repository.technician.MaintenanceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaintenanceRepositoryImplTest {

    private MaintenanceRepository repository;
    private Maintenance maintenance;

    private Maintenance getSavedMaintenance(){
        Set<Maintenance> savedMaintenances = this.repository.getAll();
        return savedMaintenances.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = MaintenanceRepositoryImpl.getRepository();
        this.maintenance = MaintenanceFactory.buildMaintenance("217025358","Christ"
        ,"Nganga", "IT technician");
    }

    @Test
    public void d_getAll() {
        Set<Maintenance> all = this.repository.getAll();
        System.out.println("get all : " + all);
    }

    @Test
    public void a_create() {
        Maintenance created = this.repository.create(this.maintenance);
        System.out.println("In create, created : " + created);
        d_getAll();
        Assert.assertSame(created, this.maintenance);
    }

    @Test
    public void c_update() {
        String updatedName = "Amour";
        String updatedLastName = "Moussiessi";
        String updatedProfession = "Plumber";

        Maintenance maintenance = new Maintenance.Builder().copy(getSavedMaintenance())
                .name(updatedName)
                .lastname(updatedLastName)
                .profession(updatedProfession)
                .build();
        System.out.println("In update, about_to_update : " +maintenance);
        Maintenance updated = this.repository.update(maintenance);
        System.out.println("In update, updated : " + updated);
        Assert.assertSame(updatedName, updated.getName());
        Assert.assertSame(updatedLastName, updated.getLastname());
        Assert.assertSame(updatedProfession, updated.getProfession());
        d_getAll();
    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(maintenance.getMaintenanceId());
        assertTrue(deleted);
        System.out.println("deleted :" + deleted);
    }

    @Test
    public void b_read() {
        Maintenance savedMaintenance = getSavedMaintenance();
        System.out.println("In read, courseId : "+ savedMaintenance.getMaintenanceId());
        Maintenance read = this.repository.read(savedMaintenance.getMaintenanceId());
        System.out.println("In read, read : " + read);
        d_getAll();
        Assert.assertEquals(savedMaintenance, read);
    }
}