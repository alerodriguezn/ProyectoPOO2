package com.mycompany.proyectopoo.jugador;

import com.mycompany.proyectopoo.interfaces.*;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * Describe al Jugador
 * @author navar
 */
public class Jugador implements iJugador{
    
    private String nombre;
    private String contrasena;
    private ArrayList<iRegistro> historial; //Guarda el juego, la duracion y los puntos que hizo.
    
    public Jugador(String nombre, String contrasena){
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
    
    public Jugador(String nombre, String contrasena, int puntos){
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    /**
     * Recupera el nombre del jugador
     * @return nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Recupera los datos del historial
     * @return historial del jugador.
     */
    public ArrayList<iRegistro> getHistorial() {
        return historial;
    }

    /**
     * Establece el nombre del jugador
     * @param nombre nombre del jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Agrega un nuevo registro al historial
     * @param registro nuevo registro del jugador
     */
    public void setRegistro(iRegistro registro) {
        historial.add(registro);
    }
    
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Registra el puntaje obtenido para una determinada partida
     * @param puntuacion puntuación obtenida
     * @param juego instancia de juego de la partida
     */
    public void registrarPuntaje(int puntuacion, iJuego juego){
        
    }

    /**
     * Listado de registros de juego del usuario para un mismo tipo de juego.
     * @param tipoJuego tipo del juego
     * @return  Registro histórico de partidas.
     */
    public ArrayList<iRegistro> estadisticas (iJuego tipoJuego){
        return null;
    
    }
    
   
    
    
    
    
}
