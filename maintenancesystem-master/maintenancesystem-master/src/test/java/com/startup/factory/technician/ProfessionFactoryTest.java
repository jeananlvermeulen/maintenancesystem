package com.startup.factory.technician;

import com.startup.entity.technician.Profession;
import com.startup.factory.technician.ProfessionFactory;
import org.junit.Assert;
import org.junit.Test;

public class ProfessionFactoryTest {

    @Test
    public void buildProfession() {
        Profession profession = ProfessionFactory.buildProfession("Plumber","everything relating to piping");
        Assert.assertNotNull(profession.getProfessionId());
        System.out.println(profession);
    }
}