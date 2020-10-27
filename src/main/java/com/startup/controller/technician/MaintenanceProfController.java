package com.startup.controller.technician;
import com.startup.entity.technician.Maintenance;
import com.startup.entity.technician.MaintenanceProf;
import com.startup.entity.technician.Profession;
import com.startup.factory.technician.MaintenanceProfFactory;
import com.startup.service.technician.impl.MaintenanceProfServiceImpl;
import com.startup.service.technician.impl.MaintenanceServiceImpl;
import com.startup.service.technician.impl.ProfessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/maintenaceprofession")
public class MaintenanceProfController {

    @Autowired
    private MaintenanceProfServiceImpl maintenanceProfService;
    @Autowired
    private MaintenanceServiceImpl maintenanceService;
    @Autowired
    private ProfessionServiceImpl professionService;

    @PostMapping("/create")
    public MaintenanceProf create(@RequestBody MaintenanceProf maintenanceProf){
        boolean existedMaintenance = false;
        boolean existedProfession = false;
        System.out.println(maintenanceProf.getMaintenanceId());
        Maintenance maintenance = maintenanceService.read(maintenanceProf.getMaintenanceId());
        if(maintenance != null){
            existedMaintenance = true;
        }
        Profession profession = professionService.read(maintenanceProf.getProfessionId());
        if(profession != null){
            existedProfession = true;
        }
        if(existedMaintenance && existedProfession){
            return maintenanceProfService.create(maintenanceProf);
        }else{
            return MaintenanceProfFactory.buildMaintenanceProf("","");
        }
    }

    @GetMapping("/all")
    public Set<MaintenanceProf> all(){
        return maintenanceProfService.getAll();
    }

    @GetMapping("/read/{id}")
    public MaintenanceProf read(@PathVariable String id){
        return maintenanceProfService.read(id);
    }
    @PostMapping("/update")
    public MaintenanceProf update(@RequestBody MaintenanceProf maintenanceProf){
        return maintenanceProfService.update(maintenanceProf);
    }

}
