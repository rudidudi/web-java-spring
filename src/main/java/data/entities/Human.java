package com.trusis.data.entities;

import com.trusis.data.entities.base.PgBase;

public class Human extends PgBase
{
    private int id;
    private String name;
    private String faction;
    
    @Override
    public void setId()
    {
       this.id=1;
        
    }

    @Override
    public void setNome()
    {
        this.name="Human";
        
    }

    @Override
    public void setFazione()
    {
        this.faction="Goods";
        
    }

    @Override
    public void setPotere()
    {
        // TODO Auto-generated method stub
        
    }
}
