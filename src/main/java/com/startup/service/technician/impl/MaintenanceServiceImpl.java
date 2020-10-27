package com.startup.service.technician.impl;
import com.startup.entity.technician.Maintenance;
import com.startup.repository.technician.MaintenanceRepository;
import com.startup.service.technician.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Override
    public Set<Maintenance> getAll() {
        return this.maintenanceRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Maintenance create(Maintenance maintenance) {
        return this.maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance read(String s) {
        return this.maintenanceRepository.findById(s).orElse(null);
    }

    @Override
    public Maintenance update(Maintenance maintenance) {
        if(this.maintenanceRepository.existsById(maintenance.getMaintenanceId())){
            return this.maintenanceRepository.save(maintenance);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.maintenanceRepository.deleteById(s);
        if(this.maintenanceRepository.existsById(s)) return false;
        else return true;
    }
}
