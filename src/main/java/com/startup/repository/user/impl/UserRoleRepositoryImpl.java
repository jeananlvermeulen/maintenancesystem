/*
Jeanan Vermeulen
215002725
*/ package com.startup.repository.user.impl;

import com.startup.entity.user.UserRole;
import com.startup.repository.user.UserRoleRepository;

import java.util.HashSet;
import java.util.Set;

public class UserRoleRepositoryImpl implements UserRoleRepository {

    private static UserRoleRepositoryImpl repository = null;
    private Set<UserRole> userRoles;

     UserRoleRepositoryImpl(){
        this.userRoles = new HashSet<>();
    }

    public static UserRoleRepositoryImpl getRepository(){
        if (repository == null) repository = new UserRoleRepositoryImpl();
        return repository;
    }
    @Override
    public Set<UserRole> getAll() {
        return userRoles;
    }

    @Override
    public UserRole create(UserRole userRole) {
        if (read(userRole.getUserId()).getroleId()) == null){
            userRoles.add(userRole);
        }
        return userRole;
    }

    @Override
    public UserRole update(UserRole userRole) {
        if (read(userRole.getUserId().getroleId()) == null){
            delete(userRole.getUserId().getroleId());
            create(userRole);
        }
        return userRole;
    }

    @Override
    public void delete(String s) {
        UserRole userRole = read(s);
        this.userRoles.remove(userRole);

    }

    @Override
    public UserRole read(String s) {
        return userRoles.stream()
                .filter(userRole -> s.equalsIgnoreCase(userRole.getUserId().getroleId()))
                .findAny()
                .orElse(null);
    }
}
