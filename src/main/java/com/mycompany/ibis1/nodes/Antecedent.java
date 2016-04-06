/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.nodes;

import com.mycompany.ibis1.Entity;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 *
 * @author khabarak-PC
 */
@NodeEntity(label="Antecedent")
public class Antecedent extends Entity{
    
    @GraphId
    private Long id;
    
    private String name;
        
    public Antecedent(){
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
