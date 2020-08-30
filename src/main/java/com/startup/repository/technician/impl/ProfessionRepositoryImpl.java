package com.startup.repository.technician.impl;

import com.startup.entity.technician.Profession;
import com.startup.repository.technician.ProfessionRepository;

import java.util.HashSet;
import java.util.Set;

public class ProfessionRepositoryImpl implements ProfessionRepository {

    private static ProfessionRepositoryImpl repository;
    private Set<Profession> professions;

    private ProfessionRepositoryImpl(){
        this.professions=new HashSet<>();
    }

    public static ProfessionRepositoryImpl getRepository(){
        if (repository == null) repository = new ProfessionRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Profession> getAll() {
        return professions;
    }

    @Override
    public Profession create(Profession profession) {
        if(read(profession.getProfessionId())==null){
            professions.add(profession);
        }
        return profession;
    }

    @Override
    public Profession update(Profession profession) {
        if(read(profession.getProfessionId() )!= null){
            delete(profession.getProfessionId());
            create(profession);
        }
        return profession;
    }

    @Override

    public void delete(String s) {
        Profession profession = read(s);
        this.professions.remove(profession);
    }

    @Override
    public Profession read(String s) {

        return professions.stream()
                .filter(profession -> s.equalsIgnoreCase(profession.getProfessionId()))
                .findAny()
                .orElse(null);
    }
}
