package com.startup.factory.technician;

import com.startup.entity.technician.Maintenance;
import com.startup.entity.technician.MaintenanceProf;

import static com.startup.util.Amr.generateId;

/**
 * @author: Christ Amour NM
 * Desc: MaintenanceFactory
 * Date: 30 June 2020
 */

public class MaintenanceFactory {

    public static Maintenance buildMaintenance(String maintenanceId, String name, String lastname, String profession){

        MaintenanceProf maintenanceProf = MaintenanceProfFactory.buildMaintenanceProf(maintenanceId, profession);
        return new Maintenance.Builder().maintenanceId(generateId())
                .maintenanceId(maintenanceId)
                .name(name)
                .lastname(lastname)
                .build();
    }
}
