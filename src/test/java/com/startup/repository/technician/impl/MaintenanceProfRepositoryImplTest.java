package com.startup.repository.technician.impl;

import com.startup.entity.technician.MaintenanceProf;
import com.startup.factory.technician.MaintenanceProfFactory;
import com.startup.repository.technician.MaintenanceProfRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaintenanceProfRepositoryImplTest {

    private MaintenanceProfRepository repository;
    private MaintenanceProf maintenanceProf;

    private MaintenanceProf getSavedMaintenanceProf(){
        Set<MaintenanceProf> savedMaintenanceProfs = this.repository.getAll();
        return savedMaintenanceProfs.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = MaintenanceProfRepositoryImpl.getRepository();
        this.maintenanceProf = MaintenanceProfFactory.buildMaintenanceProf("217025358","IT technician");
    }

    @Test
    public void d_getAll() {
        Set<MaintenanceProf> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }

    @Test
    public void a_create() {
        MaintenanceProf created = this.repository.create(this.maintenanceProf);
        System.out.println("In Create, Created : " +created);
        d_getAll();
        Assert.assertSame(created, this.maintenanceProf);
    }

    @Test
    public void c_update() {
        String newMaintenanceId = "the new maintenanceId";
        String newProfession = "new profession";
        MaintenanceProf maintenanceProf = new MaintenanceProf.Builder()
                .copy(getSavedMaintenanceProf()).maintenanceId(newMaintenanceId)
                .profession(newProfession).build();
        System.out.println("In update, about_to_updated = " + maintenanceProf);
        MaintenanceProf updated = this.repository.update(maintenanceProf);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newMaintenanceId, updated.getMaintenanceId());
        Assert.assertSame(newProfession, updated.getProfession());
        d_getAll();
    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(maintenanceProf.getMaintenanceId());
        assertTrue(deleted);
        System.out.println("deleted :" + deleted);
    }

    @Test
    public void b_read() {
        MaintenanceProf savedMaintenanceProf = getSavedMaintenanceProf();
        System.out.println("In read, maintenanceId : " + savedMaintenanceProf.getMaintenanceId());
        MaintenanceProf read = this.repository.read(savedMaintenanceProf.getMaintenanceId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedMaintenanceProf, read);
    }
}