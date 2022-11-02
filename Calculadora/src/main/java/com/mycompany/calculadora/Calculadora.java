/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.calculadora;

/**
 *
 * @author navar
 */
import java.util.ArrayList;

/**
 *
 * @author leoviquez
 */
public final class Calculadora 
{
    private ArrayList<Double> memoria;
    private static Calculadora instancia;
    
    private Calculadora()
    {
        this.memoria = new ArrayList<>();
    }
    
    public static Calculadora getInstance()
    {
        if (instancia==null)
        {
            instancia= new Calculadora();
        }
        return instancia;
    }
    
    private void registroOperacion(double registro)
    {
        this.memoria.add(registro);
    }
    
    public void listarRegistros()
    {
        
        String lista;
        for (double registro : this.memoria) 
        {
            System.out.println(registro);
        }    
        System.out.println("Fin de los registros\n\n");
    }
    
    public double suma(double a, double b)
    {
        double resultado=a+b;
        this.registroOperacion(resultado);
        return (resultado);
    }
    public double resta(double a, double b)
    {
        double resultado=a-b;
        this.registroOperacion(resultado);
        return (resultado);
    }
    
    public double multiplicacion(double a, double b)
    {
        double resultado=a*b;
        this.registroOperacion(resultado);
        return (resultado);
    }
    public double division(double a, double b)
    {
        double resultado=a/b;
        this.registroOperacion(resultado);
        return (resultado);
    }
            
}
