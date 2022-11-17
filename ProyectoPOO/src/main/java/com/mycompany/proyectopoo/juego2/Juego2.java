/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo.juego2;
import static com.mycompany.proyectopoo.ProyectoPOO.listaJugadores;
import com.mycompany.proyectopoo.interfaces.iCentroJuego;
import com.mycompany.proyectopoo.jugador.Jugador;
import com.mycompany.proyectopoo.interfaces.iJuego;
import com.mycompany.proyectopoo.interfaces.iJugador;
import com.mycompany.proyectopoo.Registro;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author navar
 */
public final class Juego2 implements iJuego {
    
    private Registro registro;
    private iCentroJuego centro;
    private String nombreJuego;
    private String descripcionJuego;
    private int puntaje = 0;
    private boolean finalizada = false;
    private static Juego2 instancia;
    private String pais;
    private String pista;
    private ArrayList<Pais> listaPaises;
    public static iJugador jugadorActual;
    
    private Juego2(){
        this.nombreJuego = "Adivina Pais";// PRUEBA
        this.descripcionJuego = "Adivina el Pais mediante varias Pistas";
        this.listaPaises = new ArrayList<>();     
    }
    
    /**
    * Retorna la instancia del juego
    * @return instancia del juego
    */
    public static Juego2 getInstancia(){
        if (instancia == null)
        {
            instancia = new Juego2();
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
                new FrameJuego2().setVisible(true);
            }
        });
    }

    /**
    * Termina la partida y recoge los datos necesarios para el registro
    */
    @Override
    public void terminarPartida(){
        registro.setJuego(getInstancia());
        registro.setFinalizacion(LocalDateTime.now());
        registro.setPuntaje(puntaje);
        registro.setPartidaFinalizada(finalizada);
        centro.agregarRegistro(registro);
        jugadorActual.registrarPuntaje(puntaje, this);
        System.out.println("Registro agregado");
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
    * Lee el archivo donde estan los paises y los almacena en un arraylist
    */
    public void getPaises(){
        try {
            File myObj = new File("./paises.txt");
            myObj.createNewFile(); 
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String nombre = myReader.nextLine();
              System.out.println(nombre);
              String pista = myReader.nextLine();
              listaPaises.add(new Pais(nombre,pista));
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("No se puede abrir el archivo.");
            e.printStackTrace();
         } catch (IOException ex) {
            Logger.getLogger(Juego2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
    * Establece aleatoriamente un pais
    */
    public void setPais(){
         Random r = new Random();
         int numAleatorio = r.nextInt(26)+1;
         Pais paisElegido = listaPaises.get(numAleatorio);
         this.pais = paisElegido.getNombre();
         this.pista = paisElegido.getRegion();
    }

    /**
    * Actualiza el puntaje
    * @param puntaje puntos que se sumaran al puntaje actual
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

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }
    

    /**
    * Devuelve el pais
    * @return pais
    */
    public String getPais() {
        return pais;
    }

    /**
    * Devuelve una pista: la region del pais
    * @return pista
    */
    public String getPista() {
        return pista;
    }   
}