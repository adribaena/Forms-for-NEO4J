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
@NodeEntity(label="Residence")
public class Residence extends Entity{

    @GraphId
    private Long id;
    
    private String location;
    
    private String province;
    
    private String autonomousCommunity;
    
    public Residence(){
    
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAutonomousCommunity() {
        return autonomousCommunity;
    }

    public void setAutonomousCommunity(String autonomousCommunity) {
        this.autonomousCommunity = autonomousCommunity;
    }
    
    
}
