/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.nodes;

import org.neo4j.ogm.annotation.NodeEntity;
import com.mycompany.ibis1.Entity;
import org.neo4j.ogm.annotation.GraphId;

/**
 *
 * @author Antonio
 */
@NodeEntity(label = "User")
public class User extends Entity {

    @GraphId
    private Long id;
    
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public User(){
        
    }
    
    public void setId(Long id){
        this.id = id;
    }

    
}
