package com.cyexm.cyzhit.DaoImpl;

import java.util.Random;

public class Tools {
    private static Random random;
    public static int getRandom1or0(){
        random = new Random();
        return random.nextInt(100)%2;
    }
}
