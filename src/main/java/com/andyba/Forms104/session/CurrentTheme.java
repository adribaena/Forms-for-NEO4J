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
 * @author Antonio
 */
@ManagedBean
@SessionScoped
public class CurrentTheme implements Serializable {

    /**
     * Creates a new instance of CurrentTheme
     */
    public CurrentTheme() {
        
    }
        
    private String theme = "ui-lightness";

    /**
     * Get the value of theme
     *
     * @return the value of theme
     */
    public String getTheme() {
        return theme;
    }


    public void setTheme(String theme) {
        this.theme = theme;
    }
    
    //este metodo no se usa por ahora, IGNORAR
    public void obtenermapa() {
        
        FacesContext context = FacesContext.getCurrentInstance();
    
    Map<String,String> params = context.getExternalContext().getRequestParameterMap();
	  String action = params.get("action");
          System.out.println(action);
          setTheme(action);
    
    }




}