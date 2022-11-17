/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author navar
 */
public interface iJuego 
{
    /**
     * Inicializa un juego asociado a un jugador y centro o controlador de juegos.
     * @param jugador jugador quien inicaliza
     * @param centroJuegos
     */
    public void iniciarPartida(iJugador jugador, iCentroJuego centroJuegos);

    /**
     * Cierra la partida en juego sin registrar puntaje para el usuario pero si almacena el registro de tiempo desde el inicio ya hasta su finalización
     * */
    public void terminarPartida();

    /**
     * Obtiene el nombre del juego
     * @return Nombre del juego
     */
    public String getNombre();

    /**
     * Obtiene la descripción del juego
     * @return Descripción del juego
     */
    public String getDescripcion();
}