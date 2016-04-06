/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.services;

import com.mycompany.ibis1.Neo4jSessionFactory;
import com.mycompany.ibis1.nodes.Person;
import java.util.Collections;
import java.util.Map;


/**
 *
 * @author khabarak-PC
 */
//@Service("personService")
public class PersonServiceImpl extends GenericService<Person> implements PersonService {
    
    @Override
    public Iterable<Map<String,Object>> getPerson() {
        String query = "match n return n";
        return Neo4jSessionFactory.getInstance().getNeo4jSession().query(query, Collections.EMPTY_MAP);
    }

    @Override
    public Class<Person> getEntityType() {
        return Person.class;
    }
}
