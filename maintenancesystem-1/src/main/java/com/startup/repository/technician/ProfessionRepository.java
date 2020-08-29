package com.startup.repository.technician;

import com.startup.entity.technician.Profession;
import com.startup.repository.IRepository;

import java.util.Set;

public interface ProfessionRepository extends IRepository<Profession, String> {
    Set<Profession> getAll();
}
