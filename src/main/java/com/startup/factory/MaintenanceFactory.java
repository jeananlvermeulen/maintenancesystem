package com.startup.factory;

import com.startup.entity.Maintenance;

import static com.startup.util.Amr.generateId;

/**
 * @author: Christ Amour NM
 * Desc: MaintenanceFactory
 * Date: 30 June 2020
 */

public class MaintenanceFactory {

    public static Maintenance buildMaintenance(String name, String lastname){
        return new Maintenance.Builder().maintenanceId(generateId())
                .name(name)
                .lastname(lastname)
                .build();
    }
}
