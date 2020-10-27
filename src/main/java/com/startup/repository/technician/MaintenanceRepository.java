package com.startup.repository.technician;

import com.startup.entity.technician.Maintenance;
import com.startup.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, String>{

}
