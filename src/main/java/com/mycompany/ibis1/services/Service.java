/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ibis1.services;

/**
 *
 * @author khabarak-PC
 */
public interface Service<T> { 
    
    Iterable<T> findAll();
    
    T find(Long id); 
    
    void delete(Long id); 
    
    T createOrUpdate(T object); 
    
}