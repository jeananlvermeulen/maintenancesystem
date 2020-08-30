/*
Golden Minenhle Ngwenya 215285840
 */
package com.startup.repository.user.impl;

import com.startup.entity.user.User;
import com.startup.repository.user.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepository repository = null;
    private Set<User> userDB;

    private UserRepositoryImpl(){
        this.userDB = new HashSet<>();
    }

    public static UserRepository getRepository(){
        if(repository == null)
            repository = new UserRepositoryImpl();
        return repository;
    }

    @Override
    public User create(User user) {
        this.userDB.add(user);
        return user;
    }

    @Override
    public User read(String id) {
        return userDB.stream()
                .filter(userDB -> id.equalsIgnoreCase(userDB.getUserId()))
                .findAny()
                .orElse(null);
    }

    @Override
    public User update(User user) {
        boolean deleteUser = delete(user.getUserId());
        if(deleteUser){
            this.userDB.add(user);
            return user;
        }

        return null;
    }

    @Override
    public boolean delete(String id) {
        User user = read(id);
        if(user != null){
            this.userDB.remove(user);
            return true;
        }
        return false;
    }

    @Override
    public Set<User> getAll() {
        return this.userDB;
    }
}
