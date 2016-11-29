package com.trusis.data.experience;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExpSettings
{
    protected static final int LEVEL_MIN = 1;
    protected static final int LEVEL_MAX = 100;
    protected static final int XP_FACTOR = 50;
    
    private static final double BASE_EXPONENT = 1.8D;
    private static final double LVL_BASE = 2.5D;
    private static final double DEC_BASE = 0.01D;
    

    
    private static int level = ExpSettings.LEVEL_MIN;
    private static int level2 = ExpSettings.LEVEL_MIN;
    private static double exponent = ExpSettings.BASE_EXPONENT;
    private static double lvlbase = ExpSettings.LVL_BASE;
    
    //DEFINE the increment of the exponent for calculating the exp/level
    private static final Map<Integer, Double> factorMap;
    static {
        Map<Integer, Double> aMap = new LinkedHashMap<Integer,Double>();
        aMap.put(20, 0.01D);//From level 1 to 20
        aMap.put(50, 0D);//From level 21 to 50
        aMap.put(100, 0.01D);//From level 51 to 100
        factorMap = Collections.unmodifiableMap(aMap);
    }
    
    //DEFINE the decrement of the base of the logarithm for calculating how much games are needed for level up
    private static final Map<Integer, Double> factorXpMap;
    static {
        Map<Integer, Double> aMap = new LinkedHashMap<Integer,Double>();
        aMap.put(20, 0.01D);//From level 1 to 20
        aMap.put(50, 0.02D);//From level 21 to 50
        aMap.put(100, 0.01D);//From level 51 to 100
        factorXpMap = Collections.unmodifiableMap(aMap);
    }
    
    //define the map with all values of the games to level up
    protected static  Map<Integer, Double> factorLvlMap;
    static {
        Map<Integer, Double> aMap = new LinkedHashMap<Integer,Double>();
        ExpSettings.factorXpMap.forEach((k,v)-> {
            for(int counter=level2;counter<=k;counter++,level2++){
                lvlbase-=v;
                aMap.put(level2, lvlbase);
            }        
        });
        factorLvlMap = Collections.unmodifiableMap(aMap);
    }
    
    //define the map with all values of experience needed to level up
    protected static Map<Integer, Double> exponentMap;
    static{
        Map<Integer, Double> aMap = new LinkedHashMap<Integer,Double>();
        ExpSettings.factorMap.forEach((k,v)-> {
            for(int counter=level;counter<=k;counter++,level++){
                exponent+=v;
                aMap.put(level, exponent);
            }        
        });
        exponentMap = Collections.unmodifiableMap(aMap);
    }

}
