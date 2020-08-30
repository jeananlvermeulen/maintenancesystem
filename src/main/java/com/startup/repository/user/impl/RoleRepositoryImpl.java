package com.startup.repository.user.impl;

import com.startup.entity.user.Role;
import com.startup.factory.user.RoleFactory;
import com.startup.repository.user.RoleRepository;

import java.util.HashSet;
import java.util.Set;

public class RoleRepositoryImpl implements RoleRepository {

    private Set<Role>roleDB;
    public RoleRepositoryImpl(){
        this.roleDB =new HashSet<>();
    }
    @Override
    public Set<Role> getAll() {
        return roleDB;
    }

    @Override
    public Role create(Role role) {
        this.roleDB.add(role);
        return role;
    }

    @Override
    public Role update(Role role) {
        Role OldRole=read(role.getRoleId());
        if(OldRole !=null){
            this.roleDB.remove(OldRole);
            this.roleDB.add(role);

        }

        return role;
    }

    @Override
    public void delete(String roleId) {
        Role role = read(roleId);
        if(role!=null)this.roleDB.remove(role);


    }

    @Override
    public Role read(String roleId) {
        Role role= this.roleDB.stream()
                .filter(r -> r.getRoleId().equalsIgnoreCase(roleId) )
                .findAny()
                .orElse( null);

        return role;
    }
}
