package com.startup.service.technician.impl;
import com.startup.entity.technician.MaintenanceProf;
import com.startup.repository.technician.MaintenanceProfRepository;
import com.startup.repository.technician.impl.MaintenanceProfRepositoryImpl;
import com.startup.service.technician.MaintenanceProfService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MaintenanceProfServiceImpl implements MaintenanceProfService {


    private static MaintenanceProfService maintenanceProfService = null;

    private MaintenanceProfRepository maintenanceProfRepository;

    private MaintenanceProfServiceImpl(){
        this.maintenanceProfRepository = MaintenanceProfRepositoryImpl.getRepository();

    }

    public static MaintenanceProfService getService(){
        if(maintenanceProfService == null) maintenanceProfService = new MaintenanceProfServiceImpl();
        return maintenanceProfService;
    }

    @Override
    public Set<MaintenanceProf> getAll() {
        return this.maintenanceProfRepository.getAll();
    }

    @Override
    public MaintenanceProf create(MaintenanceProf maintenanceProf) {
        return this.maintenanceProfRepository.create(maintenanceProf);
    }

    @Override
    public MaintenanceProf read(String s) {
        return this.maintenanceProfRepository.read(s);
    }

    @Override
    public MaintenanceProf update(MaintenanceProf maintenanceProf) {
        return this.maintenanceProfRepository.update(maintenanceProf);
    }

    @Override
    public boolean delete(String s) {
        return this.maintenanceProfRepository.delete(s);
    }
}
