package com.startup.controller.technician;
import com.startup.entity.technician.Maintenance;
import com.startup.factory.technician.MaintenanceFactory;
import com.startup.service.technician.impl.MaintenanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/maintenance")
public class MaintetnanceController {

    @Autowired
    private MaintenanceServiceImpl maintenanceService;

    @PostMapping("/create")
    public Maintenance create(@RequestBody Maintenance maintenance){
        Maintenance newMaintenance = MaintenanceFactory.buildMaintenance(maintenance.getName(), maintenance.getLastname());
        return maintenanceService.create(newMaintenance);
    }

    @GetMapping("/read/{id}")
    public Maintenance read(@PathVariable String id){
        return maintenanceService.read(id);
    }
    @PostMapping("/update")
    public Maintenance update(@RequestBody Maintenance maintenance){
        return maintenanceService.update(maintenance);
    }

    @GetMapping("/all")
    public Set<Maintenance> getAll(){
        return maintenanceService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return maintenanceService.delete(id);
    }


}
