package com.startup.controller.technician;
import com.startup.entity.technician.Profession;
import com.startup.factory.technician.ProfessionFactory;
import com.startup.service.technician.impl.ProfessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/profession")
public class ProfessionController {

    @Autowired
    private ProfessionServiceImpl professionService;

    @PostMapping("/create")
    public Profession create(@RequestBody Profession profession){
     Profession newProfession = ProfessionFactory.buildProfession(profession.getName(),
             profession.getDescription());
     return professionService.create(newProfession);
    }

    @GetMapping("/read/{id}")
    public Profession read(@PathVariable String id){
        return professionService.read(id);
    }
    @PostMapping("/update")
    public Profession update(@RequestBody Profession profession){
        return professionService.update(profession);
    }

    @GetMapping("/all")
    public Set<Profession> getAll(){
        return professionService.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return professionService.delete(id);
    }

}
