package com.startup.factory;

import com.startup.entity.Maintenance;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaintenanceFactoryTest {

    @Test
    public void buildMaintenance() {
        Maintenance maintenance = MaintenanceFactory.buildMaintenance("Christ","Nganga");
        Assert.assertNotNull(maintenance.getMaintenanceId());
        System.out.println(maintenance);
    }
}