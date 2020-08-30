/*
 UserFactory class
 4/07/2020
 215285840
 */

package com.startup.factory.user;

import com.startup.entity.user.User;

import static com.startup.util.Amr.generateId;

public class UserFactory {

    public static User buildUser(String name, String lastname){
        return new User.Builder().userId(generateId())
                .name(name)
                .lastname(lastname)
                .build();
    }


}
