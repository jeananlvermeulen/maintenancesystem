package com.startup.factory;

import com.startup.entity.User;

import static com.startup.util.Amr.generateId;

public class UserFactory {

    public static User buildUser(String name, String lastname){
        return new User.Builder().userId(generateId())
                .name(name)
                .lastname(lastname)
                .build();
    }


}
