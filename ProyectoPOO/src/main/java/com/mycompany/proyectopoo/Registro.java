/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;

import com.mycompany.proyectopoo.interfaces.iJuego;
import com.mycompany.proyectopoo.interfaces.iJugador;
import com.mycompany.proyectopoo.interfaces.iRegistro;
import com.mycompany.proyectopoo.juego1.FrameJuego1;
import com.mycompany.proyectopoo.juego2.Juego2;
import com.mycompany.proyectopoo.jugador.Jugador;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

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
    
    public Registro(iJugador jugador){
        this.jugador = jugador;
    }
    
    
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

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    
    /**
     * Obtiene la instancia del jugador
     * @return Jugador
     */
    public iJugador getJugador(){
        return this.jugador;
    
    }

    public void setPartidaFinalizada(Boolean partidaFinalizada) {
        this.partidaFinalizada = partidaFinalizada;
    }
    
    public iJuego getJuego(){
        return this.juego;
    }
    
    public void setJuego(iJuego juego) {
        this.juego = juego;
    }
    
    public static void guardarRegistros(ArrayList<iRegistro> historial) {
        try {
            FileWriter file = new FileWriter("./historial.txt");
            BufferedWriter buffer = new BufferedWriter(file);
            for (iRegistro r : historial) {
                buffer.write(r.getJuego().getNombre() + "," + r.getJugador().getNombre() + "," + r.getInicio() + "," + r.getFinalizacion() + "," + r.getPuntaje() + "," + r.getEstadoFinalizado());
                buffer.newLine();
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo.");
            e.printStackTrace();
        }
    }
    
    public static ArrayList<iRegistro> obtenerRegistros() {
        ArrayList<iRegistro> historial = new ArrayList<iRegistro>();
        try {
            File file = new File("./historial.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String linea = reader.nextLine();
                String[] r = linea.split(",");
                Registro reg = new Registro(new Jugador(r[1],""));
                if(r[0].equals("Adivina Pais")){
                    reg.setJuego(Juego2.getInstancia());
                }else if(r[0].equals("Tic Tac Toe")){
                    reg.setJuego(new FrameJuego1());
                }
                reg.setPuntaje(Integer.parseInt(r[4]));
                reg.setFinalizacion(LocalDateTime.parse(r[3]));
                reg.setInicio(LocalDateTime.parse(r[2]));        
                reg.setPartidaFinalizada(Boolean.parseBoolean(r[5]));
                historial.add(reg);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo abrir el archivo.");
            e.printStackTrace();
        }

        return historial;
    }
    
    
}
