package com.startup.service.technician.impl;

import com.startup.entity.technician.Maintenance;
import com.startup.entity.technician.Profession;
import com.startup.factory.technician.MaintenanceFactory;
import com.startup.factory.technician.ProfessionFactory;
import com.startup.service.technician.MaintenanceService;
import com.startup.service.technician.ProfessionService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaintenanceServiceImplTest {

    private static MaintenanceService maintenanceService = MaintenanceServiceImpl.getService();
    private static Maintenance maintenance = MaintenanceFactory
            .buildMaintenance("Christ","Nganga");


    @Test
    public void d_getAll() {
        Set<Maintenance> maintenances = maintenanceService.getAll();
        assertEquals(1,maintenances.size());
        System.out.println("all maintenances: " +maintenances);

    }

    @Test
    public void a_create() {
        Maintenance created = maintenanceService.create(maintenance);
        Assert.assertEquals(maintenance.getMaintenanceId(), created.getMaintenanceId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Maintenance read = maintenanceService.read(maintenance.getMaintenanceId());
        System.out.println("Read: " +read);
    }

    @Test
    public void c_update() {
        Maintenance updated = new Maintenance.Builder()
                .copy(maintenance)
                .name("Amour")
                .lastname("Moussiessi")
                .profession("Plumber")
                .build();
    }

    @Test
    public void e_delete() {
        boolean deleted = maintenanceService.delete(maintenance.getMaintenanceId());
        Assert.assertTrue(deleted);
    }
}