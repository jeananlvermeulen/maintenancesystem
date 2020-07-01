package com.startup.factory;

import com.startup.entity.MaintenanceProf;

import static com.startup.util.Amr.generateId;

public class MaintenanceProfFactory {
    public static MaintenanceProf buildMaintenanceProf(String professionId){
        return new MaintenanceProf.Builder().maintenanceId(generateId())
                .professionId(professionId)
                .build();
    }
}
