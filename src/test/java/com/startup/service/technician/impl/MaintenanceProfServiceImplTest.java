package com.startup.service.technician.impl;

import com.startup.entity.technician.Maintenance;
import com.startup.entity.technician.MaintenanceProf;
import com.startup.factory.technician.MaintenanceFactory;
import com.startup.factory.technician.MaintenanceProfFactory;
import com.startup.service.technician.MaintenanceProfService;
import com.startup.service.technician.MaintenanceService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaintenanceProfServiceImplTest {

    private static MaintenanceProfService maintenanceProfService = MaintenanceProfServiceImpl.getService();
    private static MaintenanceProf maintenanceProf = MaintenanceProfFactory
            .buildMaintenanceProf("217025358","IT technician");


    @Test
    public void a_create() {

        MaintenanceProf created = maintenanceProfService.create(maintenanceProf);
        Assert.assertEquals(maintenanceProf.getMaintenanceId(), created.getMaintenanceId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        MaintenanceProf read = maintenanceProfService.read(maintenanceProf.getMaintenanceId());
        System.out.println("Read: " +read);
    }

    @Test
    public void c_update() {

        MaintenanceProf updated = new MaintenanceProf.Builder()
                .copy(maintenanceProf)
                .maintenanceId("21700333")
                .professionId("Plumber")
                .build();
    }

    @Test
    public void d_getAll() {

        Set<MaintenanceProf> maintenanceProfs = maintenanceProfService.getAll();
        assertEquals(1,maintenanceProfs.size());
        System.out.println("all maintenances: " +maintenanceProfs);
    }

    @Test
    public void e_delete() {
        boolean deleted = maintenanceProfService.delete(maintenanceProf.getMaintenanceId());
        Assert.assertTrue(deleted);
    }
}