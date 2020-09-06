package com.startup.service.technician;

import com.startup.entity.technician.Profession;
import com.startup.service.IService;

import java.util.Set;

public interface ProfessionService extends IService<Profession, String> {
    Set<Profession> getAll();
}
