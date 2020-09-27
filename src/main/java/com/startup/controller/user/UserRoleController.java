package com.startup.controller.user;
/*Jéanan Vermeulen
 * 215002725*/
import com.startup.entity.user.UserRole;
import com.startup.factory.user.UserRoleFactory;
import com.startup.service.user.impl.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/userRole")

public class UserRoleController {

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @PostMapping("/create")
    public UserRole create(@RequestBody UserRole userRole){
        UserRole newUserRole = UserRoleFactory.buildUserRole(userRole.getRoleId());

        return userRoleService.create(newUserRole);
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
