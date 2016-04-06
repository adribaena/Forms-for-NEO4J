/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1;

import com.fasterxml.jackson.annotation.JsonProperty;



/**
 *
 * @author khabarak-PC
 */
public abstract class Entity { 
    
    @JsonProperty("id") 
    private Long id; 
    
    public Long getId() { 
        return id; 
    } 
    
    @Override 
    public boolean equals(Object o) { 
        if (this == o) return true;
        if (o == null || id == null || getClass() != o.getClass()) return false; 
        
        Entity entity = (Entity) o; 
        
        if (!id.equals(entity.id)) return false; 
        
        return true; 
    } 
    
    @Override public int hashCode() { 
        return (id == null) ? -1 : id.hashCode(); 
    } 

}