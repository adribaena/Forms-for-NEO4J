/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.relationship;


import com.mycompany.ibis1.nodes.MotorComplicationsSymptom;
import com.mycompany.ibis1.nodes.Person;
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
@RelationshipEntity(type = "HAS_MOTOR_COMPLICATION_SYMPTOM")
public class HasMotorComplicationSymptom {
    
    @GraphId
    private Long id;

    @StartNode
    private Person person;

    @EndNode
    private MotorComplicationsSymptom motorComplicationSymptom;

    @DateLong
    private Date dateMotorComplicationSymptom;
    
    public HasMotorComplicationSymptom(){
    
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public MotorComplicationsSymptom getMotorComplicationSymptom() {
        return motorComplicationSymptom;
    }

    public void setMotorComplicationSymptom(MotorComplicationsSymptom motorComplicationSymptom) {
        this.motorComplicationSymptom = motorComplicationSymptom;
    }

    public Date getDateMotorComplicationSymptom() {
        return dateMotorComplicationSymptom;
    }

    public void setDateMotorComplicationSymptom(Date dateMotorComplicationSymptom) {
        this.dateMotorComplicationSymptom = dateMotorComplicationSymptom;
    }

   

   
    

}
