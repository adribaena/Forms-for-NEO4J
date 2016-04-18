/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1;

import static com.mycompany.ibis1.Main.NEO4J_URL;
import static com.mycompany.ibis1.Main.PASSWORD;
import static com.mycompany.ibis1.Main.USERNAME;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;


public class Sesion {
    
    public Session session;
    
    public static final String NEO4J_URL = "http://localhost:7474";
    public static final String USERNAME = "neo4j";
    public static final String PASSWORD = "neo";
    
    public Sesion(){
        
    }

    public static Session getSession() {
        SessionFactory sessionFactory = new SessionFactory("com.mycompany.ibis1");
        return sessionFactory.openSession(NEO4J_URL, USERNAME, PASSWORD);
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    
}
