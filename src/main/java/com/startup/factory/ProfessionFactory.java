package com.startup.factory;

import com.startup.entity.Profession;

import static com.startup.util.Amr.generateId;

/**
 * @author: Christ Amour NM
 * Desc: ProfessionFactory
 * Date: 30 June 2020
 */

public class ProfessionFactory {

    public static Profession buildProfession(String name, String description){
        return new Profession.Builder().professionId(generateId())
                .name(name)
                .description(description)
                .build();
    }
}
