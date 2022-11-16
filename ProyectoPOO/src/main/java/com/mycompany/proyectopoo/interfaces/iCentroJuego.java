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

public interface iCentroJuego 
{
    
    /**
     * Agrega un nuevo registro  
     *
     * @param registro registro
     */
    public void agregarRegistro(iRegistro registro);
    
    /**
     * Recupera el registro histórico de partidas para todos los usuarios y sobre un mismo tipo de juego.
     * @param tipoJuego tipo de juego
     * @return  listado de registros de partidas realizadas.
     */
    public ArrayList<iRegistro> getRegistros (iJuego tipoJuego);

    /**
     * Listado de juegos disponibles en el centro de juegos
     * @return listado de juegos
     */
    public ArrayList<iJuego> getJuegosDisponibles();
    
    
    
    
}