/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.relationship;


import com.mycompany.ibis1.nodes.Person;
import com.mycompany.ibis1.nodes.MotorExaminationSymptom;
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
@RelationshipEntity(type = "REMITS_MOTOR_EXAMINATION_SYMPTOM")
public class RemitsMotorExaminationSymptom {
    
    @GraphId
    private Long id;

    @StartNode
    private Person person;

    @EndNode
    private MotorExaminationSymptom motorExaminationSymptom;

    @DateLong
    private Date dateMotorExaminationSymptom;
    
    public RemitsMotorExaminationSymptom(){
    
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

    public MotorExaminationSymptom getMotorExaminationSymptom() {
        return motorExaminationSymptom;
    }

    public void setMotorExaminationSymptom(MotorExaminationSymptom motorExaminationSymptom) {
        this.motorExaminationSymptom = motorExaminationSymptom;
    }

    public Date getDateMotorExaminationSymptom() {
        return dateMotorExaminationSymptom;
    }

    public void setDateMotorExaminationSymptom(Date dateMotorExaminationSymptom) {
        this.dateMotorExaminationSymptom = dateMotorExaminationSymptom;
    }

   


}
