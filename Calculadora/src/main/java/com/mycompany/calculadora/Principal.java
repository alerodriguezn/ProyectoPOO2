/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora;

/**
 *
 * @author navar
 */
public class Principal 
{
    public static void main(String[] args)
    {
        Calculadora calc1= Calculadora.getInstance();
        calc1.suma(10, 10);
        calc1.listarRegistros();
        calc1.suma(15, 15);
        calc1.listarRegistros();
        
        Calculadora calc2= Calculadora.getInstance();
        calc2.suma(20, 20);
        calc2.listarRegistros();
        
        JCalculadora ventana = new JCalculadora();
        ventana.setVisible(true);
        
    }
}
