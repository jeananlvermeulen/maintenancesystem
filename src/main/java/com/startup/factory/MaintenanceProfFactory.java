package com.startup.factory;

import com.startup.entity.MaintenanceProf;

import static com.startup.util.Amr.generateId;

/**
 * @author: Christ Amour NM
 * Desc: MaintenanceProfFactory
 * Date: 30 June 2020
 */

public class MaintenanceProfFactory {
    public static MaintenanceProf buildMaintenanceProf(String professionId){
        return new MaintenanceProf.Builder().maintenanceId(generateId())
                .professionId(professionId)
                .build();
    }
}
