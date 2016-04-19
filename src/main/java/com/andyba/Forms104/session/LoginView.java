/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyba.Forms104.session;

import com.mycompany.ibis1.Sesion;
import com.mycompany.ibis1.nodes.Person;
import com.mycompany.ibis1.nodes.User;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.neo4j.ogm.session.Session;

@ManagedBean
public class LoginView {

    public String user = "";
    public String password = "";

    public LoginView() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String save() {
        
        User p = new User();   
        
        p.setUsername(user);
        p.setPassword(password);
        
        Session session = Sesion.getSession();
        session.save(p);        
              
        return "/faces/index.xhtml?faces-redirect=true";

    }       
}
