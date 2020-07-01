package com.startup.factory;

import com.startup.entity.Profession;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfessionFactoryTest {

    @Test
    public void buildProfession() {
        Profession profession = ProfessionFactory.buildProfession("Plumber","everything relating to piping");
        Assert.assertNotNull(profession.getProfessionId());
        System.out.println(profession);
    }
}