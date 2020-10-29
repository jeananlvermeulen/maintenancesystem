package com.startup.service.user.impl;

import com.startup.entity.user.User;
import com.startup.repository.user.UserRepository;
import com.startup.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User user) {
        return this.repository.save(user);
    }

    @Override
    public User read(String id) {
        return this.repository.findById(id).orElseGet(null);
    }

    @Override
    public User update(User user) {
        if (this.repository.existsById(user.getUserId())){
            return this.repository.save(user);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        if(this.repository.existsById(id)) return false;
        else return true;
    }

    @Override
    public Set<User> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
