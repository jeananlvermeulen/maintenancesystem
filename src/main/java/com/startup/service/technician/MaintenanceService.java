package com.startup.service.technician;

import com.startup.entity.technician.Maintenance;
import com.startup.service.IService;

import java.util.Set;

public interface MaintenanceService extends IService {

    Set<Maintenance> getAll();
}
