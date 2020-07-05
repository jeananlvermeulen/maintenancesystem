package com.startup.factory;

import com.startup.entity.Profession;

import static com.startup.util.Amr.generateId;

public class ProfessionFactory {

    public static Profession buildProfession(String name, String description){
        return new Profession.Builder().professionId(generateId())
                .name(name)
                .description(description)
                .build();
    }
}
