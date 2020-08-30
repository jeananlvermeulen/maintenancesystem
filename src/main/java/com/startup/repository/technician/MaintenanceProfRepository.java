package com.startup.repository.technician;

import com.startup.entity.technician.MaintenanceProf;
import com.startup.repository.IRepository;

import java.util.Set;

public interface MaintenanceProfRepository extends IRepository<MaintenanceProf, String> {

    Set<MaintenanceProf> getAll();
}
