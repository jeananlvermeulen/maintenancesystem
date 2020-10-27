package com.startup.service.technician.impl;

import com.startup.entity.technician.Profession;
import com.startup.repository.technician.ProfessionRepository;
import com.startup.service.technician.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ProfessionServiceImpl implements ProfessionService {

    @Autowired
    private ProfessionRepository professionRepository;


    @Override
    public Set<Profession> getAll() {
        return this.professionRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Profession create(Profession profession) {
        return this.professionRepository.save(profession);
    }

    @Override
    public Profession read(String s){
        return this.professionRepository.findById(s).orElse(null);
    }

    @Override
    public Profession update(Profession profession) {
        if(this.professionRepository.existsById(profession.getProfessionId())){
        return this.professionRepository.save(profession);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.professionRepository.deleteById(s);
        if(this.professionRepository.existsById(s)) return false;
        else return true;
    }
}
