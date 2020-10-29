package com.startup.service.user.impl;

import com.startup.entity.user.Role;
import com.startup.repository.user.RoleRepository;

import com.startup.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Set<Role> getAll() {

        return this.roleRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Role create(Role role) {

        return this.roleRepository.save(role);
    }
    @Override
    public Role read(String roleId) {

        return this.roleRepository.findById(roleId).orElseGet(null);
    }

    @Override
    public Role update(Role role) {

        return this.roleRepository.save(role);
    }

    @Override
    public boolean delete(String s) {
         this.roleRepository.deleteById(s);
         if(this.roleRepository.existsById(s))return false;
         else return true;

    }

}

