package com.startup.service.user.impl;

import com.startup.entity.user.User;
import com.startup.repository.user.UserRepository;
import com.startup.repository.user.impl.UserRepositoryImpl;
import com.startup.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static UserService service = null;
    private UserRepository repository;

    private UserServiceImpl(){
        this.repository = UserRepositoryImpl.getRepository();
    }

    public static UserService getService(){
        if(service == null)
            service = new UserServiceImpl();
        return service;
    }

    @Override
    public User create(User user) {
        return this.repository.create(user);
    }

    @Override
    public User read(String id) {
        return this.repository.read(id);
    }

    @Override
    public User update(User user) {
        return this.repository.update(user);
    }

    @Override
    public boolean delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Set<User> getAll() {
        return this.repository.getAll();
    }
}
