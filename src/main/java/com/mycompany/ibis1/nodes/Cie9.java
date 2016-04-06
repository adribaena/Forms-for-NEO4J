/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.nodes;

import org.neo4j.ogm.annotation.GraphId;

/**
 *
 * @author khabarak-PC
 */
public class Cie9 extends Criterion {

    @GraphId
    private Long id;

    private String comments;

    public Cie9() {

    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
