/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyba.Forms104.session;

import static com.mycompany.ibis1.Main.NEO4J_URL;
import static com.mycompany.ibis1.Main.PASSWORD;
import static com.mycompany.ibis1.Main.USERNAME;
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

        /*RequestContext context = RequestContext.getCurrentInstance();
        String cosa =  firstname + " , " + lastname;
        boolean loggedIn = true;
        FacesMessage message = null;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome ", cosa); 
        
        FacesContext.getCurrentInstance().addMessage(null,message);
        context.addCallbackParam("loggedIn", loggedIn);
         */
        RequestContext context = RequestContext.getCurrentInstance();
        Person p = new Person();
        p.setId_person("23432");
        p.setNhc("1235659");
        p.setName(firstname);
        String j = "ga";

        j = p.getId_person();

        // FacesContext.getCurrentInstance().addMessage(null,
        //       new FacesMessage("Welcome " + firstname + " " + j));// + p.getName()));
        String cosa = firstname + " , con id =  " + j;
        boolean loggedIn = true;
        FacesMessage message = null;
        message = new FacesMessage("Welcome ", cosa);

        FacesContext.getCurrentInstance().addMessage(null, message);

        SessionFactory sessionFactory = new SessionFactory("com.mycompany.ibis1");

        // Create the session
        Session session = sessionFactory.openSession(NEO4J_URL, USERNAME, PASSWORD);

        session.save(p);
        
        
        
        
        Iterable<Person> persons = session.query(Person.class, "MATCH (p:Person) return p", Collections.<String, Object>emptyMap());

        /*
        for (Person per : persons) {
            System.out.println(per.getName());
        }
        */

        //context.addCallbackParam("loggedIn", loggedIn);
        
        
        return "/faces/index.xhtml?faces-redirect=true";

    }

}