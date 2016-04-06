/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.nodes;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 *
 * @author khabarak-PC
 */
@NodeEntity(label = "ParkinsonDisease")
public class ParkinsonDisease extends Diagnostic {

    @GraphId
    private Long id;

    public ParkinsonDisease() {

    }

}
