/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.relationship;

import com.mycompany.ibis1.Entity;
import com.mycompany.ibis1.nodes.Person;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 *
 * @author khabarak-PC
 */
@RelationshipEntity(type="ARE_FAMILY")
public class AreFamily extends Entity{
    
    @GraphId
    private Long id;

    @StartNode
    private Person person1;

    @EndNode
    private Person person2;
    
    private String relation;
    
    public AreFamily(){
    
    }

    public Person getPerson1() {
        return person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
    
    
}
