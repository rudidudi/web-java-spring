package com.trusis.data.experience;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExpConfig extends ExpSettings {

    //MAP that defines how much exp is needed for level up
    public static Map<Integer, Integer> xpMap;
    static{
        Map<Integer, Integer> aMap = new LinkedHashMap<Integer,Integer>();
        exponentMap.forEach((k,v)->{
            Integer exp = (int) ExpUtils.round((ExpSettings.XP_FACTOR*(Math.pow(k,v))),0);
            aMap.put(k, exp);
        });     
        xpMap = Collections.unmodifiableMap(aMap);
    }
    
    //MAP that defines how many games a player have to do to level up
    public static Map<Integer, Double> levelUpGamesMap;
    static{
        Map<Integer, Double> aMap = new LinkedHashMap<Integer,Double>();
        ExpSettings.factorLvlMap.forEach((k,v)->{ 
            double asd= 0D;
            asd =ExpUtils.logOfBase(k,v);
            
            aMap.put(k,asd );
        });
        levelUpGamesMap = Collections.unmodifiableMap(aMap);
        //override first and second argument.
        levelUpGamesMap.put(1, 1D);
        levelUpGamesMap.put(2, 1.1D);
    }
    
    //MAP that defines how much exp you get for a game
    public static Map<Integer,Integer> xpForGame;   
    static{  
        Map<Integer, Integer> aMap = new LinkedHashMap<Integer,Integer>();
        for(int counter = LEVEL_MIN; counter <= LEVEL_MAX;counter++){
            int xpForGame = (int) (xpMap.get(counter)/levelUpGamesMap.get(counter));
            aMap.put(counter, xpForGame);
        } 
        xpForGame = Collections.unmodifiableMap(aMap);
    }
    static double tot=0D;
    //@TestMethod Run As Java Application
    public static void main(String[] args) throws IOException
    {
        
        ExpConfig.levelUpGamesMap.forEach((k,v)->{
            
            tot=tot+v;
            System.out.println(k + " : " + v + " = " + tot);
            
        });
    }
    
}