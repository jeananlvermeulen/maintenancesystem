package com.startup.factory.technician;

import com.startup.entity.technician.Profession;

import static com.startup.util.Amr.generateId;

/**
 * @author: Christ Amour NM
 * Desc: ProfessionFactory
 * Date: 30 June 2020
 */

public class ProfessionFactory {

    public static Profession buildProfession(String profName, String profDesc){
        return new Profession.Builder().professionId(generateId())
                .profName(profName)
                .profDesc(profDesc)
                .build();
    }
}
