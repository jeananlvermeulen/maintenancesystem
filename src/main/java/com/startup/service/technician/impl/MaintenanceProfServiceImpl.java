package com.startup.service.technician.impl;
import com.startup.entity.technician.MaintenanceProf;
import com.startup.repository.technician.MaintenanceProfRepository;
import com.startup.service.technician.MaintenanceProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MaintenanceProfServiceImpl implements MaintenanceProfService {

    @Autowired
    private MaintenanceProfRepository maintenanceProfRepository;

    @Override
    public Set<MaintenanceProf> getAll() {
        return this.maintenanceProfRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public MaintenanceProf create(MaintenanceProf maintenanceProf) {
        return this.maintenanceProfRepository.save(maintenanceProf);
    }

    @Override
    public MaintenanceProf read(String s) {
        return this.maintenanceProfRepository.findById(s).orElse(null);
    }

    @Override
    public MaintenanceProf update(MaintenanceProf maintenanceProf) {
        if(this.maintenanceProfRepository.existsById(maintenanceProf.getMaintenanceId())){
            return this.maintenanceProfRepository.save(maintenanceProf);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.maintenanceProfRepository.deleteById(s);
        if(this.maintenanceProfRepository.existsById(s)) return false;
        else return true;
    }
}
