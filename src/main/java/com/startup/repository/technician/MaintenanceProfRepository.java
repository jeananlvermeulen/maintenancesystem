package com.startup.repository.technician;

import com.startup.entity.technician.MaintenanceProf;
import com.startup.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MaintenanceProfRepository extends JpaRepository<MaintenanceProf, String>{

}