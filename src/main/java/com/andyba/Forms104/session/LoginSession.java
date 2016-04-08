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

    private String usuario;
    private final FacesContext facesContext;
    private final HttpServletRequest httpServletRequest;
    private FacesMessage message;
    private boolean compruebaSesion = false;

    public LoginSession() {

        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
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

        compruebaSesion = httpServletRequest.getSession().getAttribute("sessionUsuario") != null;

        if (compruebaSesion == true) {

            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);

            //RequestContext.getCurrentInstance().showMessageInDialog(message);

            facesContext.addMessage(null, message);
        }
        return compruebaSesion;
    }

    public String cerrarSesion() {

        httpServletRequest.getSession().removeAttribute("sessionUsuario");
       // message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        //facesContext.addMessage(null, message);
        return "/faces/index.xhtml?faces-redirect=true";
    }

}
