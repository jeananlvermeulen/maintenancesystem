package com.startup.service.technician.impl;
import com.startup.entity.technician.Maintenance;
import com.startup.repository.technician.MaintenanceRepository;
import com.startup.repository.technician.impl.MaintenanceRepositoryImpl;
import com.startup.service.technician.MaintenanceService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private static MaintenanceService maintenanceService = null;

    private MaintenanceRepository maintenanceRepository;

    private MaintenanceServiceImpl(){
        this.maintenanceRepository = MaintenanceRepositoryImpl.getRepository();

    }

    public static MaintenanceService getService(){
        if(maintenanceService == null) maintenanceService = new MaintenanceServiceImpl();
        return maintenanceService;
    }

    @Override
    public Set<Maintenance> getAll() {
        return this.maintenanceRepository.getAll();
    }

    @Override
    public Maintenance create(Maintenance maintenance) {
        return this.maintenanceRepository.create(maintenance);
    }

    @Override
    public Maintenance read(String s) {
        return this.maintenanceRepository.read(s);
    }

    @Override
    public Maintenance update(Maintenance maintenance) {
        return this.maintenanceRepository.update(maintenance);
    }

    @Override
    public boolean delete(String s) {
        return this.maintenanceRepository.delete(s);
    }
}
