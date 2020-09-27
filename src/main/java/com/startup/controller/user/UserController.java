package com.startup.controller.user;

import com.startup.entity.user.User;
import com.startup.factory.user.UserFactory;
import com.startup.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @PostMapping("/create")
    public User create(@RequestBody User user){
        User newUser = UserFactory.buildUser(user.getName(),user.getLastname());
        return service.create(newUser);
    }

    @GetMapping("/read/{id}")
    public User read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){return service.update(user);}

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){ return service.delete(id);}

    @GetMapping("/all")
    public Set<User> getAll(){return service.getAll();}

}
