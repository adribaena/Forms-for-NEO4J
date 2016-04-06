/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.relationship;

import com.mycompany.ibis1.Entity;
import com.mycompany.ibis1.nodes.Person;
import com.mycompany.ibis1.nodes.Antecedent;
import java.util.Date;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

/**
 *
 * @author khabarak-PC
 */
@RelationshipEntity(type="HAS_ANTECEDENT")
public class HasAntecedent extends Entity{
    
    @GraphId
    private Long id;
    
    @StartNode
    private Person person;

    @EndNode
    private Antecedent antecedent;
    
    private String type;
    
    private String relation;
    
    @DateLong
    private Date dateAntecedent;
    
    public HasAntecedent(){
    
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Antecedent getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(Antecedent antecedent) {
        this.antecedent = antecedent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Date getDateAntecedent() {
        return dateAntecedent;
    }

    public void setDateAntecedent(Date dateAntecedent) {
        this.dateAntecedent = dateAntecedent;
    }

    
    
    
}
