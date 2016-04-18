/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package com.andyba.Forms104.session;

import static com.mycompany.ibis1.Main.NEO4J_URL;
import static com.mycompany.ibis1.Main.PASSWORD;
import static com.mycompany.ibis1.Main.USERNAME;
import com.mycompany.ibis1.Sesion;
import com.mycompany.ibis1.nodes.Person;
import java.util.Collections;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Antonia
 */
@ManagedBean
public class UserView {

    private String firstname = "";
    private String lastname = "";
    public static final String NEO4J_URL = "http://localhost:7474";
    public static final String USERNAME = "neo4j";
    public static final String PASSWORD = "neo";

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String save() {
        
        Person p = new Person();   
        p.setNhc(lastname);
        p.setName(firstname);
        FacesMessage message = new FacesMessage("Welcome ", p.getName());
        FacesContext.getCurrentInstance().addMessage(null, message);
        Session session = Sesion.getSession();
        session.save(p);
        
        //esto queda descartado
        /*  
        Iterable<Person> persons = session.query(Person.class, "MATCH (p:User) return p", Collections.<String, Object>emptyMap());

        
        for (Person per : persons) {
            System.out.println(per.getName());
        }
        */
              
        return "/faces/index.xhtml?faces-redirect=true";

    }

}