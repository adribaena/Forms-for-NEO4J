/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.relationship;



import com.mycompany.ibis1.Entity;
import com.mycompany.ibis1.nodes.Person;
import com.mycompany.ibis1.nodes.Criterion;
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
@RelationshipEntity(type = "NOT_MEETS_CRITERIA")
public class NotMeetsCriteria extends Entity {

    @GraphId
    private Long id;

    @StartNode
    private Person person;

    @EndNode
    private Criterion criterion;

    @DateLong
    private Date dateCriteria;

    public NotMeetsCriteria() {

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    public void setCriterion(Criterion criterion) {
        this.criterion = criterion;
    }

    public Date getDateCriteria() {
        return dateCriteria;
    }

    public void setDateCriteria(Date dateCriteria) {
        this.dateCriteria = dateCriteria;
    }

}
