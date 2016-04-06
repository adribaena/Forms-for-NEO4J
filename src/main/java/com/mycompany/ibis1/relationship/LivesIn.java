/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.relationship;

import com.mycompany.ibis1.Entity;
import com.mycompany.ibis1.nodes.Person;
import com.mycompany.ibis1.nodes.Residence;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 *
 * @author khabarak-PC
 */
@RelationshipEntity(type="LIVES_IN")
public class LivesIn extends Entity{
    
    @GraphId
    private Long id;
    
    @StartNode
    private Person person;
    
    @EndNode
    private Residence residence;
    
    public LivesIn(){
        
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }
    
    
}
