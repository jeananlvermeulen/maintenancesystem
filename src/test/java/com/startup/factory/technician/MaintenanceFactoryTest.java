package com.startup.factory.technician;

import com.startup.entity.technician.Maintenance;
import com.startup.factory.technician.MaintenanceFactory;
import org.junit.Assert;
import org.junit.Test;

public class MaintenanceFactoryTest {

    @Test
    public void buildMaintenance() {
        Maintenance maintenance = MaintenanceFactory.buildMaintenance("Christ","Nganga",
                "IT technician");
        Assert.assertNotNull(maintenance.getMaintenanceId());
        System.out.println(maintenance);
    }
}