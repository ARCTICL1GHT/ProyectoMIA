/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomia;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner S=new Scanner(System.in);
        String p;
        Archivos mp3=new Archivos();
        int a;
        mp3.extencion="agenda.dat";
        while(true)
        {
            System.out.println("1. Ingresar Cancion");
            System.out.println("2. Mostrar datos de cancion");
            System.out.println("3.Salir");
            a=S.nextInt();
            if(1==a)
            {
                p=S.next();
                mp3.extencion=p;
            }
            else if(2==a)
            {
                try {
                    mp3.MostrarA(mp3.extencion);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(3==a)
            {
                System.exit(0);
            }
            
        }
    }
    
}
