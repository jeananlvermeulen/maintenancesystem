package com.startup.service.user.impl;
/* Jeanan Vermeulen
    215002725
*/

import com.startup.entity.user.UserRole;
import com.startup.repository.user.UserRoleRepository;
import com.startup.repository.user.impl.UserRoleRepositoryImpl;
import com.startup.service.user.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private static UserRoleService userRoleService = null;
    private UserRoleRepository userRoleRepository;

    private UserRoleServiceImpl(){

        this.userRoleRepository = UserRoleRepositoryImpl.getRepository();
    }

    public static UserRoleService getService(){
        if (userRoleService == null) userRoleService = new UserRoleServiceImpl();
        return userRoleService;
    }

    @Override
    public Set<UserRole> getAll() {
        return this.userRoleRepository.getAll();
    }

    @Override
    public UserRole create(UserRole userRole) {
        return this.userRoleRepository.create(userRole);
    }

    @Override
    public UserRole read(String s) {
        return this.userRoleRepository.read(s);
    }

    @Override
    public UserRole update(UserRole userRole) {
        return this.userRoleRepository.update(userRole);
    }

    @Override
    public boolean delete(String s) {
        return this.userRoleRepository.delete(s);
    }
}
