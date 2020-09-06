package com.startup.service.technician;
import com.startup.entity.technician.MaintenanceProf;
import com.startup.service.IService;
import java.util.Set;

public interface MaintenanceProfService extends IService<MaintenanceProf, String> {

    Set<MaintenanceProf> getAll();
}
