/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.nodes;


import com.mycompany.ibis1.Entity;
import java.util.HashSet;
import java.util.Set;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 *
 * @author khabarak-PC
 */
@NodeEntity(label = "Criterion")
public class Criterion extends Entity {

    @GraphId
    private Long id;

    private String name;

    public Criterion() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Relationship(type = "CRITERIA_DIAGNOSTIC", direction = Relationship.OUTGOING)
    private Set<ParkinsonDisease> criteriaDiagnostic = new HashSet();

    public Set<ParkinsonDisease> getCriteriaDiagnostic() {
        return criteriaDiagnostic;
    }

    public void setCriteriaDiagnostic(Set<ParkinsonDisease> criteriaDiagnostic) {
        this.criteriaDiagnostic = criteriaDiagnostic;
    }

}
