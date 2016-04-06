/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.relationship;

import com.mycompany.ibis1.Entity;
import com.mycompany.ibis1.nodes.Person;
import com.mycompany.ibis1.nodes.Treatment;
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
@RelationshipEntity(type="HAS_TREATMENT")
public class HasTreatment extends Entity{
    
    @GraphId
    private Long id;
    
    @StartNode
    private Person person;
    
    @EndNode
    private Treatment treatment;
    
    @DateLong
    private Date dateTreatment;
    
    public HasTreatment(){
    
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Date getDateTreatment() {
        return dateTreatment;
    }

    public void setDateTreatment(Date dateTreatment) {
        this.dateTreatment = dateTreatment;
    }
    
}
