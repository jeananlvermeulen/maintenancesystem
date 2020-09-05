package com.startup.service.user.impl;

import com.startup.entity.user.Role;
import com.startup.repository.user.RoleRepository;
import com.startup.repository.user.impl.RoleRepositoryImpl;
import com.startup.service.user.RoleService;

import java.util.Set;

public class RoleServiceImpl implements RoleService {

    private static RoleService roleService = null;
    private RoleRepository roleRepository;

    private RoleServiceImpl() {

        this.roleRepository = RoleRepositoryImpl.getRepository();
    }

    public static RoleService getService() {
        if (roleService == null) roleService = new RoleServiceImpl();
        return roleService;

    }

    @Override
    public Set<Role> getAll() {

        return this.roleRepository.getAll();
    }

    @Override
    public Role create(Role role) {

        return this.roleRepository.create(role);
    }

    @Override
    public Role read(String roleId) {

        return this.roleRepository.read(roleId);
    }

    @Override
    public Role update(Role role) {

        return this.roleRepository.update(role);
    }

    @Override
    public boolean delete(String s) {


        return this.roleRepository.delete(s);
    }

}

