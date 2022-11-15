/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;

import com.mycompany.proyectopoo.interfaces.iJuego;
import com.mycompany.proyectopoo.interfaces.iJugador;
import com.mycompany.proyectopoo.interfaces.iRegistro;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author navar
 */
public class Registro implements iRegistro {
   
    private Boolean partidaFinalizada;
    private LocalDateTime inicioPartida;
    private LocalDateTime finalPartida;
    private iJuego juego;
    private iJugador jugador;
    private int puntaje;
    
    
    /**
     * Recupera la fecha/hora de inicio de la partida
     * @return fecha/Hora de inicio de la partida
     */
    public LocalDateTime getInicio(){
        return this.inicioPartida;
        
    }

    /**
     * Recupera la fecha/hora de finalización de la partida
     * @return fecha/hora de finalización del juego
     */
    public LocalDateTime getFinalizacion(){
        
        return this.finalPartida;
    }

    /**
     * Asigna la fecha/hora de inicio de la partida
     * @param fechaHora fecha/hora de inicio de la partida
     */
    public void setInicio(LocalDateTime fechaHora){
        this.inicioPartida = fechaHora;
    
    }

    /**
     * Asigna la fecha/hora de finalización de la partida
     * @param fechaHora fecha/hora de finalización de la partida
     */
    public void setFinalizacion(LocalDateTime fechaHora){
        this.finalPartida = fechaHora;
    }

    /**
     * Retorna el puntaje obtenido en la partida, null en caso de terminar la partida sin completar.
     * @return puntaje obtenido
     */
    public int getPuntaje(){
        return this.puntaje;
    }

    /**
     * Retorna el total de segundos transcurridos desde el inicio de la partida y la finalización
     * @return  total de segundos
     */
    public int getSegundosTotalesPartida(){
        return (int) Duration.between(this.inicioPartida, this.finalPartida).getSeconds();
    }
    
    /**
     * Retorna el estado de finalización de la partida, True si terminó con éxito la partida y registra puntuación, false si finlaiza la partida sin terminar el juego.
     * @return estado de finalización de juego
     */
    public boolean getEstadoFinalizado(){
        return this.partidaFinalizada;
    
    }

    
    /**
     * Obtiene la instancia del jugador
     * @return Jugador
     */
    public iJugador getJugador(){
        return this.jugador;
    
    }
    
    public iJuego getJuego(){
        return this.juego;
    }
    
    
}
