/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo.juego1;
import static com.mycompany.proyectopoo.ProyectoPOO.listaJugadores;
import com.mycompany.proyectopoo.interfaces.iCentroJuego;
import com.mycompany.proyectopoo.jugador.Jugador;
import com.mycompany.proyectopoo.interfaces.iJuego;
import com.mycompany.proyectopoo.interfaces.iJugador;
import com.mycompany.proyectopoo.Registro;


import java.time.LocalDateTime;
/**
 * Juego Tic Tac Toe
 * @author navar
 */
public final class Juego1 implements iJuego {
    
    private Registro registro;
    private iCentroJuego centro;
    private String nombreJuego;
    private String descripcionJuego;
    private int puntaje = 0;
    private static Juego1 instancia;
    public static iJugador jugadorActual;
    private boolean finalizada = false;
    
    private Juego1(){
        this.nombreJuego = "Tic Tac Toe";// PRUEBA
        this.descripcionJuego = "Coloca tres marcas respectivas en una fila horizontal, vertical o diagonal para ganar"; 
    }
    
    /**
    * Retorna la instancia del juego
    * @return instancia del juego
    */
    public static Juego1 getInstancia(){
        if (instancia == null)
        {
            instancia = new Juego1();
        }
        return instancia;
    
    }
    
    /**
     * Inicializa un juego asociado a un jugador y centro o controlador de juegos.
     * @param jugador jugador quien inicaliza
     * @param centroJuegos
     */
    @Override
    public void iniciarPartida(iJugador jugador, iCentroJuego centroJuegos){
        registro = new Registro(jugador);
        
        registro.setInicio(LocalDateTime.now());
        
        this.jugadorActual = jugador;
        this.centro = centroJuegos;
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameJuego1().setVisible(true);
            }
        });

    }

    /**
    * Termina la partida y recoge los datos necesarios para enviarlos al registro
    */
    @Override
    public void terminarPartida(){
        registro.setJuego(getInstancia());
        registro.setFinalizacion(LocalDateTime.now());
        registro.setPuntaje(puntaje);
        registro.setPartidaFinalizada(finalizada);
        centro.agregarRegistro(registro);
        jugadorActual.registrarPuntaje(puntaje, this);
    }

    /**
     * Obtiene el nombre del juego
     * @return Nombre del juego
     */
    @Override
    public String getNombre(){
        return this.nombreJuego;
    }

    /**
     * Obtiene la descripción del juego
     * @return Descripción del juego
     */
    @Override
    public String getDescripcion(){
        return this.descripcionJuego;
    
    }
    
    /**
     * Actualiza si la partida fue finalizada
     * @param finalizada partida finalizada
     */
    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }
    
    /**
    * Actualiza el puntaje
    * @param puntaje Total de puntos que se van a sumar
    */
    public void setPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }
    
    /**
    * Actualiza el puntaje
    */
    public void setPuntaje2() {
        this.puntaje = 0;
    }
}
