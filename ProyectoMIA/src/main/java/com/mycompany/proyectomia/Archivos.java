/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis2
 */
public class Archivos {
    public String extencion;
    public void MostrarA(String Archivo) throws FileNotFoundException
    {
        /* RandomAccessFile archivo=new RandomAccessFile("agenda.dat", "rw");
        try {
            archivo.seek(0);
            System.out.println(archivo.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       
            RandomAccessFile archivo=new RandomAccessFile(Archivo, "rw");
        try {
            archivo.seek(0);
            System.out.println(archivo.readLine());
            archivo.seek(0);
            for(int i=0;i<archivo.length();i++)
            {
                     System.out.println(archivo.readByte());
            }
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
}
