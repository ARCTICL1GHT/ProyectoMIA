/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomia;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
/**
 *
 * @author luis2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        InputStream is = null;
        Scanner S=new Scanner(System.in);
        byte[] buffer = new byte[5];
        char c;
        String p;
        Archivos mp3=new Archivos();
        int a;
        while(true)
        {
            System.out.println("1. Ingresar Cancion");
            System.out.println("2. Mostrar datos de cancion");
            System.out.println("3.Salir");
            a=S.nextInt();
            if(1==a)
            {         
                System.out.println("Ingresar ubicacion");
                p="C:\\Users\\luis2\\Downloads\\y2mate.com - Nothing Left To Say  Rocks (Medley).mp3";
                mp3.SetExtencion(p);
            }
            else if(2==a)
            {
                try {
                    System.out.println(mp3.Mostrar());
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
