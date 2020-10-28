package com.startup.repository.user;

import com.startup.entity.user.UserRole;
import com.startup.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {

}
