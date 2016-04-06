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
@NodeEntity(label="Family")
public class Family extends Entity{
    
    @GraphId
    private Long id;
    
    private String familyId;
    
    public Family(){
    
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }
    
    
}
