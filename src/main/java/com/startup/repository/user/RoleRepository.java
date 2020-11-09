package com.startup.repository.user;

import com.startup.entity.user.Role;
import com.startup.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
}
