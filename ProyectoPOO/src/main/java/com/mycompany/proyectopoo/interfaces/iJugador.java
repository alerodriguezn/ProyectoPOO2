/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectopoo.interfaces;

/**
 *
 * @author navar
 */
import java.util.ArrayList;

public interface iJugador 
{
    /**
     * Obtiene el nombre del jugador
     * @return nombre del jugador
     */
    public String getNombre();

    /**
     * Registra el puntaje obtenido para una determinada partida
     * @param puntuacion puntuación obtenida
     * @param juego instancia de juego de la partida
     */
    public void registrarPuntaje(int puntuacion, iJuego juego);

    /**
     * Listado de registros de juego del usuario para un mismo tipo de juego.
     * @param tipoJuego tipo del juego
     * @return  Registro histórico de partidas.
     */
    public ArrayList<iRegistro> estadisticas (iJuego tipoJuego);
}