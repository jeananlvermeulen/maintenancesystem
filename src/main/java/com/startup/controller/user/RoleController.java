package com.startup.controller.user;

import com.startup.entity.user.Role;
import com.startup.factory.user.RoleFactory;
import com.startup.service.user.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/Role")

public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @PostMapping("/create")
    public Role create(@RequestBody Role role) {
        Role newRole = RoleFactory.buildRole(role.getRoleId(), role.getType());
        return roleService.create(newRole);


    }

    @GetMapping("/read{roleId}")
    public Role read(@PathVariable String roleId) {
        return roleService.read(roleId);
    }

    @PostMapping("/update")
    public Role update(@RequestBody Role role) {
        return roleService.update(role);
    }

    @GetMapping("/all")
    public Set<Role> getAll() {
        return roleService.getAll();

    }

    @DeleteMapping("/delete/{roleId}")
    public boolean delete(@PathVariable String roleId) {
        return roleService.delete(roleId);
    }
}