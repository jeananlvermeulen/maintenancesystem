package com.startup.factory.technician;

import com.startup.entity.technician.MaintenanceProf;
/**
 * @author: Christ Amour NM
 * Desc: MaintenanceProfFactory
 * Date: 30 June 2020
 */

public class MaintenanceProfFactory {
    public static MaintenanceProf buildMaintenanceProf(String maintenanceId, String profession){
        return new MaintenanceProf.Builder()
                .maintenanceId(maintenanceId)
                .profession(profession)
                .build();
    }
}
