/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyba.Forms104.session;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


/**
 *
 * @author Antonia
 */
@ManagedBean
@SessionScoped
public class CurrentTheme implements Serializable {

    /**
     * Creates a new instance of CurrentTheme
     */
    public CurrentTheme() {
        
    }
        
    private String theme = "aristo";

    /**
     * Get the value of theme
     *
     * @return the value of theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Set the value of theme
     *
     * @param theme new value of theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }
    
    public void obtenermapa() {
        
        FacesContext context = FacesContext.getCurrentInstance();
    
    Map<String,String> params = context.getExternalContext().getRequestParameterMap();
	  String action = params.get("action");
          System.out.println(action);
          setTheme(action);
    
    }


    /**
     * Get the value of themes
     *
     * @return the value of themes
     */



}
