package com.startup.factory;

import com.startup.entity.MaintenanceProf;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaintenanceProfFactoryTest {

    @Test
    public void buildMaintenanceProf() {
        MaintenanceProf maintenanceProf = MaintenanceProfFactory.buildMaintenanceProf("324r4321hjscjcbjsn");
        Assert.assertNotNull(maintenanceProf.getMaintenanceId());
        System.out.println(maintenanceProf);
    }
}