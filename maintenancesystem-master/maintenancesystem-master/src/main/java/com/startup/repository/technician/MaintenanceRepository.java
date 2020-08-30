package com.startup.repository.technician;

import com.startup.entity.technician.Maintenance;
import com.startup.repository.IRepository;

import java.util.Set;

public interface MaintenanceRepository extends IRepository<Maintenance, String> {

    Set<Maintenance> getAll();
}
