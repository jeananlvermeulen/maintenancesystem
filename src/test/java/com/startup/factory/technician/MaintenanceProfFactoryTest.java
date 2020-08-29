package com.startup.factory.technician;

import com.startup.entity.technician.MaintenanceProf;
import com.startup.factory.technician.MaintenanceProfFactory;
import org.junit.Assert;
import org.junit.Test;

public class MaintenanceProfFactoryTest {

    @Test
    public void buildMaintenanceProf() {
        MaintenanceProf maintenanceProf = MaintenanceProfFactory.buildMaintenanceProf("324r4321hjscjcbjsn","plumber");
        Assert.assertNotNull(maintenanceProf.getMaintenanceId());
        System.out.println(maintenanceProf);
    }
}