package com.startup.service.technician.impl;

import com.startup.entity.technician.Profession;
import com.startup.repository.technician.ProfessionRepository;
import com.startup.repository.technician.impl.ProfessionRepositoryImpl;
import com.startup.service.technician.ProfessionService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class ProfessionServiceImpl implements ProfessionService {

    private static ProfessionService professionService = null;

    private ProfessionRepository professionRepository;

    private ProfessionServiceImpl(){
        this.professionRepository = ProfessionRepositoryImpl.getRepository();

    }

    public static ProfessionService getService(){
        if(professionService == null) professionService = new ProfessionServiceImpl();
        return professionService;
    }


    @Override
    public Set<Profession> getAll() {
        return this.professionRepository.getAll();
    }

    @Override
    public Profession create(Profession profession) {
        return this.professionRepository.create(profession);
    }

    @Override
    public Profession read(String s){
        return this.professionRepository.read(s);
    }

    @Override
    public Profession update(Profession profession) {
        return this.professionRepository.update(profession);
    }

    @Override
    public boolean delete(String s) {
        return this.professionRepository.delete(s);
    }
}
