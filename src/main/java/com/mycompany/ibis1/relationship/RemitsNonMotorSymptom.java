/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.relationship;

import com.mycompany.ibis1.Entity;
import com.mycompany.ibis1.nodes.Person;
import com.mycompany.ibis1.nodes.NonMotorSymptom;
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
@RelationshipEntity(type = "REMITS_NON_MOTOR_SYMPTOM")
public class RemitsNonMotorSymptom extends Entity{
    
    @GraphId
    private Long id;

    @StartNode
    private Person person;

    @EndNode
    private NonMotorSymptom nonMotorSymptom;

    @DateLong
    private Date dateNonMotorSymptom;
    
    public RemitsNonMotorSymptom(){
    
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public NonMotorSymptom getNonMotorSymptom() {
        return nonMotorSymptom;
    }

    public void setNonMotorSymptom(NonMotorSymptom nonMotorSymptom) {
        this.nonMotorSymptom = nonMotorSymptom;
    }

    public Date getDateNonMotorSymptom() {
        return dateNonMotorSymptom;
    }

    public void setDateNonMotorSymptom(Date dateNonMotorSymptom) {
        this.dateNonMotorSymptom = dateNonMotorSymptom;
    }
    
}
