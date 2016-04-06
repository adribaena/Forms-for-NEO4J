/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1;

import java.awt.event.ActionEvent;
import javax.faces.event.AbortProcessingException;

/**
 *
 * @author khabarak-PC
 */
public class Login {

    private String username;
    private String password;

    public void onLogin(ActionEvent e) {
        if (!username.equalsIgnoreCase("dukes") && !username.equalsIgnoreCase("admin")) {
            throw new AbortProcessingException("Usuario invalido");
        }
// password=null;
    }

    public String submit() {
        String outcome = "none";
        if (username.equalsIgnoreCase("dukes")) {
            outcome = "success";
        } else {
            outcome = "admin";
        }

        System.out.println(outcome);
        return outcome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
