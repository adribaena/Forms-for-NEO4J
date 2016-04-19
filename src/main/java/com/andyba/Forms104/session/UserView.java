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
import java.util.Date;
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

    private String nhc = "";
    private String name = "";
    private String first_surname = "";
    private String second_surname = "";
    private String genre = "";
    private Date dateOfBirth;
    private String race = "";
    private String telephone = "";
    private String exitus = "";
    public static final String NEO4J_URL = "http://localhost:7474";
    public static final String USERNAME = "neo4j";
    public static final String PASSWORD = "neo";

    public UserView() {
    }

    public String getNhc() {
        return nhc;
    }

    public void setNhc(String nhc) {
        this.nhc = nhc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_surname() {
        return first_surname;
    }

    public void setFirst_surname(String first_surname) {
        this.first_surname = first_surname;
    }

    public String getSecond_surname() {
        return second_surname;
    }

    public void setSecond_surname(String second_surname) {
        this.second_surname = second_surname;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getExitus() {
        return exitus;
    }

    public void setExitus(String exitus) {
        this.exitus = exitus;
    }

    

    public String save() {
        
        Person p = new Person();   
        
        p.setFirst_surname(first_surname);
        p.setName(name);
        p.setDateOfBirth(dateOfBirth);
        p.setExitus(exitus);
        p.setSecond_surname(second_surname);
        p.setNhc(nhc);
        p.setRace(race);
        p.setTelephone(telephone);
        p.setGenre(genre);
        
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