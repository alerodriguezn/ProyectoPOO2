package com.mycompany.proyectopoo.jugador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * Describe al Jugador
 * @author navar
 */
public class Jugador {
    
    private String nombre;
    private String contrasena;
    private int puntos;
    
    public Jugador(String nombre, String contrasena){
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.puntos = 0;// Se inicia el puntaje en 0 para cada usuario
    }
    
    public Jugador(String nombre, String contrasena, int puntos){
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.puntos = puntos;
    }

    /**
     * Recupera el nombre del jugador
     * @return nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Recupera los puntos del jugador
     * @return puntos del jugador.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Establece el nombre del jugador
     * @param nombre nombre del jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece los puntos del jugador
     * @param puntos puntos del jugador
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    /**
     * Agregar puntos al jugador
     * @param puntos puntos que se van a agregar
     */
    public void agregarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public String getContrasena() {
        return contrasena;
    }
    
   
    
    
    
    
}
