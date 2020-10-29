package com.startup.service.user.impl;
/* Jeanan Vermeulen
    215002725
*/

import com.startup.entity.user.UserRole;
import com.startup.repository.user.UserRoleRepository;
import com.startup.service.user.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.Set;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public Set<UserRole> getAll() {
        return this.userRoleRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public UserRole create(UserRole userRole) {
        return this.userRoleRepository.save(userRole);
    }

    @Override
    public UserRole read(String s) {
        return this.userRoleRepository.findById(s).orElse(null);
    }

    @Override
    public UserRole update(UserRole userRole) {
        if (this.userRoleRepository.existsById(userRole.getUserId())) {
            return this.userRoleRepository.save(userRole);
        }
        return null;

    }

    @Override
    public boolean delete(String s) {
        this.userRoleRepository.deleteById(s);
        if(this.userRoleRepository.existsById(s)) return false;
        else return true;
    }
}
