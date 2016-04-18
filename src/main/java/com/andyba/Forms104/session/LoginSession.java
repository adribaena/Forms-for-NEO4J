/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyba.Forms104.session;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Antonio
 */
@RequestScoped
@ManagedBean
public class LoginSession {
   
    //disponemos de un atributo que identifica al usuario logueado
    private String usuario;
    //tenemos además un backbean para obtener información de una vista o de otro bean
    private final FacesContext facesContext;
    //declaramos un objeto para el manejo del servidor y poder comprobar en cada acceso a una página si estamos logueados
    private final HttpServletRequest httpServletRequest;
    //finalmente un boolean que compruebe si estamos logueados
    private boolean compruebaSesion = false;

    public LoginSession() {

        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        
        //si estamos logueados, es porque en la HttpServletRequest hemos guardado un atributo sessionUsuario con el nombre del ususario
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
            //actualizamos el valor del usuario en el constructor
            usuario = httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isCompruebaSesion() {
        return compruebaSesion;
    }

    public void setCompruebaSesion(boolean compruebaSesion) {
        this.compruebaSesion = compruebaSesion;
    }

    public boolean compruebaSesion() {
        //devuelve true si el atributo sessionUsuario existe
        return httpServletRequest.getSession().getAttribute("sessionUsuario") != null;
    }

    public String cerrarSesion() {

        //destruye el atributo sessionUsuario del la petición httpServletRequest
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        //nos redirigimos a la web principal, gracias al faces-redirect=true
        return "/faces/index.xhtml?faces-redirect=true";
    }

}
