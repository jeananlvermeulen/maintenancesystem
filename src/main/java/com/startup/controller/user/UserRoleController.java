package com.startup.controller.user;
/*Jéanan Vermeulen
 * 215002725*/
import com.startup.entity.technician.Maintenance;
import com.startup.entity.technician.MaintenanceProf;
import com.startup.entity.technician.Profession;
import com.startup.entity.user.Role;
import com.startup.entity.user.User;
import com.startup.entity.user.UserRole;
import com.startup.factory.technician.MaintenanceProfFactory;
import com.startup.factory.user.UserRoleFactory;
import com.startup.service.user.impl.RoleServiceImpl;
import com.startup.service.user.impl.UserRoleServiceImpl;
import com.startup.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/userRole")

public class UserRoleController {

    @Autowired
    private UserRoleServiceImpl userRoleService;
    @Autowired
    private RoleServiceImpl roleService;
    @Autowired
    private UserServiceImpl service;

    @PostMapping("/create")
    public UserRole create(@RequestBody UserRole userRole){
        boolean existedRole = false;
        boolean existedUser = false;
        System.out.println(userRole.getRoleId());

        Role role = roleService.read(userRole.getRoleId());
        if(role != null){
            existedRole = true;
        }
        User user = service.read(userRole.getUserId());
        if(user != null){
            existedUser = true;
        }
        if(existedRole && existedUser){
            return userRoleService.create(userRole);
        }else{
            return UserRoleFactory.buildUserRole("");
        }
    }


    @GetMapping("/read/{id}")
    public UserRole read(@PathVariable String id){
        return userRoleService.read(id);
    }

    @PostMapping("/update")
    public UserRole update(@RequestBody UserRole userRole){
        return userRoleService.update(userRole);
    }

    @GetMapping("/all")
    public Set<UserRole> getAll(){
        return userRoleService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return  userRoleService.delete(id);
    }

}
