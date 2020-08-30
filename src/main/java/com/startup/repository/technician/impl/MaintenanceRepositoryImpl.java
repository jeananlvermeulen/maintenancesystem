package com.startup.repository.technician.impl;

import com.startup.entity.technician.Maintenance;
import com.startup.repository.technician.MaintenanceRepository;

import java.util.*;

public class MaintenanceRepositoryImpl implements MaintenanceRepository {

    private static MaintenanceRepositoryImpl repository = null;
    private Map<String,Maintenance> maintenances;

    private MaintenanceRepositoryImpl(){
        this.maintenances = new HashMap<>();
    }

    public  static MaintenanceRepositoryImpl getRepository(){
        if(repository == null) repository = new MaintenanceRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Maintenance> getAll() {
        Collection<Maintenance> maintenances = this.maintenances.values();
        Set<Maintenance> set = new HashSet<>();
        set.addAll(maintenances);
        return set;
    }

    @Override
    public Maintenance create(Maintenance maintenance) {
        if(read(maintenance.getMaintenanceId()) == null){
            this.maintenances.put(maintenance.getMaintenanceId(),maintenance);
        }
        return maintenance;
    }

    @Override
    public Maintenance update(Maintenance maintenance) {
        if(read(maintenance.getMaintenanceId()) != null){
            maintenances.replace(maintenance.getMaintenanceId(), maintenance);
        }
        return maintenance;
    }

    @Override
    public void delete(String s) {
        Maintenance maintenance = read(s);
        this.maintenances.remove(s, maintenance);

    }

    @Override
    public Maintenance read(String s) {
        return this.maintenances.get(s);
    }
}
