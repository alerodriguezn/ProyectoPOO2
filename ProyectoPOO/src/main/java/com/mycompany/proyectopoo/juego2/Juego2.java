/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo.juego2;
import static com.mycompany.proyectopoo.ProyectoPOO.listaJugadores;
import com.mycompany.proyectopoo.jugador.Jugador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author navar
 */
public final class Juego2 {
    
    private int puntaje = 0;
    private static Juego2 instancia;
    private String pais;
    private String pista;
    private ArrayList<Pais> listaPaises;
    
    private Juego2(){
        this.listaPaises = new ArrayList<>();     
    }
    
    public static Juego2 getInstancia(){
        if (instancia == null)
        {
            instancia= new Juego2();
        }
        return instancia;
    
    }
    
    
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
    
    public void setPais(){
         Random r = new Random();
         int numAleatorio = r.nextInt(26)+1;
         Pais paisElegido = listaPaises.get(numAleatorio);
         this.pais = paisElegido.getNombre();
         this.pista = paisElegido.getRegion();
    
    }

    public String getPais() {
        return pais;
    }

    public String getPista() {
        return pista;
    }
    

    
    

    
}
