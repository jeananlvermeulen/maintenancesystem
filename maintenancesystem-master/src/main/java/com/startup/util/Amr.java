package com.startup.util;

import java.util.UUID;

public class Amr {
    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
