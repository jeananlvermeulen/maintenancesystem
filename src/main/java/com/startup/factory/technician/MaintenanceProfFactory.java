package com.startup.factory.technician;

import com.startup.entity.technician.MaintenanceProf;
/**
 * @author: Christ Amour NM
 * Desc: MaintenanceProfFactory
 * Date: 30 June 2020
 */

public class MaintenanceProfFactory {
    public static MaintenanceProf buildMaintenanceProf(String maintenanceId, String professionId){
        return new MaintenanceProf.Builder()
                .maintenanceId(maintenanceId)
                .professionId(professionId)
                .build();
    }
}
