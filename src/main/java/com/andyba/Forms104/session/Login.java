/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyba.Forms104.session;

import com.mycompany.ibis1.Sesion;
import com.mycompany.ibis1.nodes.Person;
import com.mycompany.ibis1.nodes.User;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.neo4j.ogm.session.Session;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Antonia
 */
@ManagedBean
public class Login {

    public String user;
    public String password;

    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;

    public Login() {

        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();

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

    public String login() {

                //mapa de claves / valores
        Session session = Sesion.getSession();
        Iterable<User> nodos = session.query(User.class, "MATCH (n:User)  RETURN n", Collections.<String, Object> emptyMap());
                //pasamos el iterador a un mapa de claves y valores, siendo la clave el usuario, y el valor la contraseña
        Map<String,String> claves = Iter2Map(nodos);
        
        if (claves.containsKey(user) && claves.get(user).equals(password)){
            httpServletRequest.getSession().setAttribute("sessionUsuario", user);
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);

            faceContext.addMessage(null, facesMessage);

            return "/faces/index.xhtml";
        } else {
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecto", null);

            faceContext.addMessage(null, facesMessage);
            return null;
        }
    }

    private Map<String, String> Iter2Map(Iterable<User> nodos) {
       
        Map<String,String> mapa = new HashMap<String, String>() {};
        
        for(User usuario : nodos){
            mapa.put(usuario.getUsername(),usuario.getPassword());
        }
        
        return mapa;
    }

}
