/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.services;

import com.mycompany.ibis1.nodes.Person;
import java.util.Map;

/**
 *
 * @author khabarak-PC
 */
public interface PersonService extends Service<Person>{
    
    Iterable<Map<String,Object>> getPerson();
    
}
