/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo.juego2;

/**
 *Clase que describe las caracteristicas del pais
 * 
 * @author navar
 */
public class Pais {
    private String nombre;
    private String region;

    public Pais(String nombre, String region) {
        this.nombre = nombre;
        this.region = region;
    }

    /**
    * Devulve el nombre del pais
    * @return nombre del pais
    */
    public String getNombre() {
        return nombre;
    }
    
    /**
    * Devulve la region del pais
    * @return region del pais
    */
    public String getRegion() {
        return region;
    }

    /**
    * Asigna el nombre del pais
    * @param nombre nombre del pais
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
    * Asigna la region del pais
    * @param region region del paus
    */
    public void setRegion(String region) {
        this.region = region;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
