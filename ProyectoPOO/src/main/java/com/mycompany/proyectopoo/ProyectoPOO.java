/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectopoo;
import com.mycompany.proyectopoo.jugador.Jugador;
import com.mycompany.proyectopoo.login.*;



import java.util.ArrayList;

import java.io.*;

/**
 *
 * @author navar
 */
public class ProyectoPOO {
    public static ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

    //Funciones con archivos
    
    /**
     * Crea un nuevo directorio
     * @param ruta Recibe la ruta del lugar donde estara la carpeta
     * @param nombreCarpeta Nombre que tendra la nueva carpeta
     */
    public static void crearCarpeta(String ruta, String nombreCarpeta)
    {
        new File(ruta+"/"+nombreCarpeta).mkdir();
    }
    
    /**
    * Crea un archivo
    * @param ruta Ruta donde estara el nuevo archivo
    * @param nombreArchivo Nombre del nuevo archivo a crear
    */
    public static void crearArchivo(String ruta, String nombreArchivo)
    {
        try {
            new File(ruta+"/"+nombreArchivo).createNewFile();
        } catch (IOException ex) {
            System.out.println("El archivo no se ha podido crear debido a que ya existe u otro error");
        }
    }
            
    /**
    * Retorna un string con el texto completo de un archivo de texto 
    * @param rutaConArchivo Ruta del archivo incluido el archivo a leer
    */
    public static String leerArchivo(String rutaConArchivo)
    {
        String textoLeido = "";
        //LEER ARCHIVO DE TEXTO
        try{
            BufferedReader bf = new BufferedReader(new FileReader(rutaConArchivo));
            String temp = "";
            String bfRead;
            
            while((bfRead = bf.readLine())!=null){
                //va leyendo linea por linea y bfRead cada vez va tener una nueva linea de texto hasta qie sea diferente de nulo
                 temp = temp + bfRead; //Guardamos el texto del archivo
            }
            textoLeido = temp;
        }catch(IOException e){
            System.out.println("No se encontro el archivo");
            return null;
        }
        return textoLeido;
    }
            
    /**
     * Escribe en un archivo un texto enviado por parametro
     * @param ruta Stirng con la ruta del archivo a escribir
     * @param texto String con el texto a escribir en el archivo
     */
    public static void escribirEnArchivo(String ruta, String texto)
    {   
        try {
            FileWriter escritura = new FileWriter(ruta);
            for(int x=0;x<texto.length();x++){
                escritura.write(texto.charAt(x));
            }
            escritura.close();
        } catch (IOException ex) {
            System.out.println("No se ha podido escribir en el archivo debido a que ya existe u otro error");
        }
    }
    
    public static void main(String[] args) {
        new JLogin().setVisible(true);
    }
}
